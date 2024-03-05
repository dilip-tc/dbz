package com.dk.dbz.data.api

import com.dk.dbz.data.api.model.ZCharacter
import retrofit2.http.GET

interface ZCharacterApi {
    // so this will give as teh list of characters
    @GET(ApiConstants.CHARACTER_EP)
    suspend fun getZCharacter():List<ZCharacter>

//    @GET("")
//    suspend fun getZgh(): String

}