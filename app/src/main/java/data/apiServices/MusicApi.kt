package com.nazlicanterliksiz.deezerapp.service

import data.model.ArtistModel
import data.model.MusicCategoryModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.deezer.com/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface MusicApiService{
    @GET("genre",)
    suspend fun getCategory(): Response<MusicCategoryModel>

    @GET("{genre_id}/artists")
    suspend fun getArtist(@Path("id") id: Int): Response<ArtistModel>
}

object MusicCategoryApi {
    val retrofitCategoryService: MusicApiService by lazy { retrofit.create(MusicApiService::class.java) }
}

object ArtistApi {
    val retrofitArtistService: MusicApiService by lazy { retrofit.create(MusicApiService::class.java) }
}


