package com.shalatan.data.routes

import com.shalatan.data.*
import com.shalatan.data.collections.Note
import com.shalatan.data.requests.AddOwnerRequest
import com.shalatan.data.requests.DeleteNoteRequest
import com.shalatan.data.responses.SimpleResponse
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.notesRoutes() {
    route("/getNotes") {
        //this block will ensure only authenticated users can notes
        authenticate {
            get {
                val email = call.principal<UserIdPrincipal>()!!.name
                val notes = getNotesForUser(email)
                call.respond(HttpStatusCode.OK, notes)
            }
        }
    }
    route("/addNote") {
        authenticate {
            post {
                val note = try {
                    call.receive<Note>()
                } catch (e: ContentTransformationException) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@post
                }
                if (saveNote(note = note)) {
                    call.respond(HttpStatusCode.OK, "OK")
                } else {
                    call.respond(HttpStatusCode.Conflict, "Conflict")
                }
            }
        }
    }
    route("/deleteNote") {
        authenticate {
            post {
                val email = call.principal<UserIdPrincipal>()!!.name
                val request = try {
                    call.receive<DeleteNoteRequest>()
                } catch (e: ContentTransformationException) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@post
                }
                if (deleteNoteForUser(email, request.noteId)) {
                    call.respond(HttpStatusCode.OK, "Deleted")
                } else {
                    call.respond(HttpStatusCode.Conflict, "Not Deleted")
                }
            }
        }
    }
    route("/addOwner") {
        authenticate {
            post {
                val request = try {
                    call.receive<AddOwnerRequest>()
                } catch (e: ContentTransformationException) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@post
                }
                if (!checkIfUserExists(email = request.owner)) {
                    call.respond(
                        HttpStatusCode.OK,
                        SimpleResponse(false, "No user with this e-mail exists")
                    )
                    return@post
                }
                if (isOwnerOfNote(noteID = request.noteId, owner = request.owner)) {
                    call.respond(
                        HttpStatusCode.OK,
                        SimpleResponse(false, "Already an Owner")
                    )
                    return@post
                }
                if (addOwnerToNote(noteID = request.noteId, owner = request.owner)) {
                    call.respond(
                        HttpStatusCode.OK,
                        SimpleResponse(true, "User Added Successfully")
                    )
                } else {
                    call.respond(HttpStatusCode.Conflict, "Conflict")
                }
            }
        }
    }
}