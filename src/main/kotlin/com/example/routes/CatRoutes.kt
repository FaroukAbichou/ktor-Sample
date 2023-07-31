package com.example.routes

import com.example.data.local.cats
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.catRouting() {
    get("/cat") {
        call.respondText(cats.toString())
    }
}