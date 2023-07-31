package com.example.routes

import com.example.data.local.cats
import com.example.domain.Cat
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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

        post {
            val cat = call.receive<Cat>()
            cats.add(cat)
            call.respondText("Cat stored correctly", status = HttpStatusCode.Created)
        }
    }
}

private fun ApplicationRequest.isContentTypeValid(): Boolean {
    val contentType = this.contentType().toString()
    return contentType == ContentType.Application.Json.toString()
}