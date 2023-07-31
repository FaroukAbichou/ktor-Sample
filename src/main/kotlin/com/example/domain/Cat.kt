package com.example.domain

import kotlinx.serialization.Serializable


@Serializable
data class Cat(
    val id: Int,
    val name: String,
    val breed: String,
    val age: Int
)