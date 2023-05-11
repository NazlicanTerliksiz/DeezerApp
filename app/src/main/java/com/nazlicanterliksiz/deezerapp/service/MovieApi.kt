package com.nazlicanterliksiz.deezerapp.service

import com.nazlicanterliksiz.deezerapp.model.MusicCategoryModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.deezer.com/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface MusicApiService{
    @GET("genre")
    suspend fun getMusic(): Response<MusicCategoryModel>
}

object MusicApi {
    val retrofitService: MusicApiService by lazy { retrofit.create(MusicApiService::class.java) }
}