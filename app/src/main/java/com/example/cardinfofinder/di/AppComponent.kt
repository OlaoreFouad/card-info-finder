package com.example.cardinfofinder.di

import com.example.cardinfofinder.data.remote.LookupBinService
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [AppModule::class])
interface AppComponent {

    val retrofit: Retrofit

}