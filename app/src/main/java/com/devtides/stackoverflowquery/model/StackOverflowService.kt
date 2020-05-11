package com.devtides.stackoverflowquery.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StackOverflowService {
    private val BASE_URL = "https://api.stackexchange.com/"

    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StackOverflowApi::class.java)
}