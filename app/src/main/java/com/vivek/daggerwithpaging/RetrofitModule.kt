package com.vivek.daggerwithpaging

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Cons.BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getQuoteAPI(retrofit: Retrofit): APIService{
        return retrofit.create(APIService::class.java)
    }
}