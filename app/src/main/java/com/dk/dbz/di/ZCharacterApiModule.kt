package com.dk.dbz.di

import com.dk.dbz.data.api.ApiConstants.BASE_URL
import com.dk.dbz.data.api.ZCharacterApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object ZCharacterApiModule {

    fun provideRetrofit():ZCharacterApi{
//        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//        val retrofitBuilder = Retrofit.Builder()
//            .baseUrl(ApiConstants.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
//        return retrofitBuilder.create(ZCharacterApi::class.java)

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val gson = GsonBuilder
        //https://hp-api.onrender.com/api/characters
        val retrofit = Retrofit.Builder().client(client).baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(moshi)).build()
        return retrofit.create(ZCharacterApi::class.java)

    }
}