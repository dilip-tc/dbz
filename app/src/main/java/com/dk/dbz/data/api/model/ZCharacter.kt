package com.dk.dbz.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class ZCharacter(
    @Json(name = "affiliation")
    val affiliation: String,
    @Json(name = "deletedAt")
    val deletedAt: String?,
    @Json(name = "description")
    val description: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "id")
    val id: Int, 
    @Json(name = "image")
    val image: String,
    @Json(name = "ki")
    val ki: String,
    @Json(name = "maxKi")
    val maxKi: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "originPlanet")
    val originPlanet: OriginPlanet,
    @Json(name = "race")
    val race: String,
    @Json(name = "transformations")
    val transformations: List<Transformation>
)