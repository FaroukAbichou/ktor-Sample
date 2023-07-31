package com.example.routes

import com.example.data.local.cats
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.catRouting() {
    route("/cat") {
        get {
            call.respond(cats)
        }
        get("{id?}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val cat = cats.find { it.id == id }
            if (cat == null) {
                call.respondText("No cat with id $id", status = HttpStatusCode.BadRequest)
            } else {
                call.respond(cat)
            }
        }
    }
}