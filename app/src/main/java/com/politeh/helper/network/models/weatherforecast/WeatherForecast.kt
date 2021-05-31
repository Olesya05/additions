package com.politeh.helper.network.models.weatherforecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.politeh.helper.network.models.weatherforecast.CurrentWeather
import com.politeh.helper.network.models.weatherforecast.Location
import com.politeh.helper.network.models.weatherforecast.forecast.Forecast
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherForecast(
    @SerializedName("location") val location: Location,
    @SerializedName("current") val currentWeather: CurrentWeather,
    @SerializedName("forecast") val forecast: Forecast
): Parcelable