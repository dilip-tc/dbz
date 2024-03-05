package com.dk.dbz.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Transformation(
    @Json(name = "deletedAt")
    val deletedAt: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "ki")
    val ki: String,
    @Json(name = "name")
    val name: String
)