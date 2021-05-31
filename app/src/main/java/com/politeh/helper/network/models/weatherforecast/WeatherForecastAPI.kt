package com.politeh.helper.network.models.weatherforecast

import com.politeh.helper.network.models.weatherforecast.WeatherForecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastAPI {


    @GET("/v1/forecast.json?key=3ebf40eb74864e3ea94135724201210&days=3")
    fun getWeatherForecast(@Query("q") location: String): Call<WeatherForecast>


}