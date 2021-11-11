package com.example.cardinfofinder.di

import com.example.cardinfofinder.data.remote.LookupBinService
import com.example.cardinfofinder.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun retrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.LOOKUP_BASE_URL)
            .client(client)
            .build()
    }

    @Provides
    fun lookupBINService(retrofit: Retrofit): LookupBinService {
        return retrofit.create(LookupBinService::class.java)
    }

//    @Provides
//    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
//
//        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
//
//    }
//
//    @Provides
//    fun loggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//    }

}