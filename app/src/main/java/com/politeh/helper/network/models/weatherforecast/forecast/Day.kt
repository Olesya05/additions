package com.politeh.helper.network.models.weatherforecast.forecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.politeh.helper.network.models.weatherforecast.WeatherCondition
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Day(
    @SerializedName("maxtemp_c") val maxTemperatureC: Float,
    @SerializedName("mintemp_c") val minTemperatureC: Float,
    @SerializedName("avgtemp_c") val averageTemperatureC: Float,
    @SerializedName("maxwind_kph") val maxWindSpeedKph: Float,
    @SerializedName("totalprecip_mm") val totalPrecipitationMm: Float,
    @SerializedName("avghumidity") val averageHumidity: Float,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int,
    @SerializedName("condition") val condition: WeatherCondition
): Parcelable