package com.shalatan

import com.shalatan.data.routes.testingRoute
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(DefaultHeaders)
        install(CallLogging)
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }
        install(Routing) {
//            registerRoute()
//            logInRoute()
//            notesRoutes()
            testingRoute()
        }
    }.start(wait = true)
}

//@Suppress("unused") // Referenced in application.conf
//@kotlin.jvm.JvmOverloads
//fun Application.module(testing: Boolean = false) {
//    install(DefaultHeaders)
//    install(CallLogging)
//    install(ContentNegotiation) {
//        gson {
//            setPrettyPrinting()
//        }
//    }
    //authenticate feature must be above routing feature
//    install(Authentication) {
//        configureAuth()
//    }
//    install(Routing) {
//        registerRoute()
//        logInRoute()
//        notesRoutes()
//        testingRoute()
//    }
//    CoroutineScope(Dispatchers.IO).launch {
//        print("AAA CheckIfUserExists ${checkIfUserExists("abc")}\n")
//        print("AAA CheckIfPassWordMatches ${checkPasswordForEmail("abc", "abc")}\n")
//        print("AAA GetNotesForUser ${getNotesForUser("abc")}\n")
//        val newNote = Note(
//            title = "New Update",
//            content = "New Content",
//            date = 123,
//            owners = listOf("abc"),
//            colour = "#fff",
//            id = "lmnop"
//        )
//        print("AAA Inserting Note${saveNote(newNote)}")
//    }
//}

///**
// * logic on how to authenticate the user
// */
//private fun Authentication.Configuration.configureAuth() {
//    //TODO : currently using basic authentication, upgrade later
//    basic {
//        realm = "Notes Server"
//        validate { credentials ->
//            val email = credentials.name
//            val password = credentials.password
//            if (checkPasswordForEmail(email, password)) {
//                UserIdPrincipal(email)
//            } else null
//        }
//    }
//}
