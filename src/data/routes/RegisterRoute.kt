package com.shalatan.data.routes

import com.shalatan.data.collections.User
import com.shalatan.data.requests.AccountRequest
import com.shalatan.data.responses.SimpleResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.registerRoute() {
    route("/register") {
        post {
//            val request = try {
//                call.receive<AccountRequest>()
//            } catch (e: ContentTransformationException) {
//                call.respond(HttpStatusCode.BadRequest)
//                return@post
//            }
//            val userExists = checkIfUserExists(request.email)
//            if (!userExists) {
//                if (registerUser(User(request.email, request.password))) {
//                    call.respond(HttpStatusCode.OK, SimpleResponse(true, "Account Successfully Created"))
//                } else {
//                    call.respond(HttpStatusCode.OK, SimpleResponse(false, "Unknown Error"))
//                }
//            } else {
//                call.respond(HttpStatusCode.OK, SimpleResponse(false, "Used Email Exists"))
//            }
        }
    }
}