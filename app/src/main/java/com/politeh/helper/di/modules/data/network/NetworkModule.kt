package com.politeh.helper.di.modules.data.network

import com.politeh.helper.network.WeatherRestAPI.Companion.BASE_URL
import com.politeh.helper.network.models.searchinglocation.SearchingLocationAPI
import com.politeh.helper.network.models.weatherforecast.WeatherForecastAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import javax.inject.Singleton

@Module(includes = [
])
object NetworkModule {


    @Singleton
    @Provides
    fun provideWeatherNetwork(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideWeatherForecastAPI(retrofit: Retrofit): WeatherForecastAPI {
        return retrofit.create(WeatherForecastAPI::class.java)
    }


    @Singleton
    @Provides
    fun provideSearchingLocationAPI(retrofit: Retrofit): SearchingLocationAPI {
        return retrofit.create(SearchingLocationAPI::class.java)
    }


}