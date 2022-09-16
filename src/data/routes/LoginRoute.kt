package com.shalatan.data.routes

import com.shalatan.data.requests.AccountRequest
import com.shalatan.data.responses.SimpleResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.logInRoute() {
    route("/login") {
        post {
//            val request = try {
//                call.receive<AccountRequest>()
//            } catch (e: ContentTransformationException) {
//                call.respond(HttpStatusCode.BadRequest)
//                return@post
//            }
//            val isPasswordCorrect = checkPasswordForEmail(request.email, request.password)
//            if (isPasswordCorrect) {
//                call.respond(HttpStatusCode.OK, SimpleResponse(true, "Successfully Logged In !"))
//            } else {
//                call.respond(HttpStatusCode.OK, SimpleResponse(false, "Invalid Credentials"))
//            }
        }
    }
}