package com.example.cardinfofinder.data.remote

import com.example.cardinfofinder.data.models.info_finder.CardInfoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface LookupBinService {

    @GET("{number}")
    suspend fun lookupBIN(
        @Path("number") number: String,
        @Header("Accept-Version") acceptVersion: Int = 3
    ): CardInfoResponse

}

