package com.dk.dbz.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OriginPlanet(
    @Json(name = "deletedAt")
    val deletedAt: String?,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "isDestroyed")
    val isDestroyed: Boolean,
    @Json(name = "name")
    val name: String
)