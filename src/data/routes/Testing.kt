package com.shalatan.data.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.testingRoute() {
    route("/testing") {
        get {
            call.respond(HttpStatusCode.OK,"Waah Kya Testing Ki Hei !!")
        }
    }
}