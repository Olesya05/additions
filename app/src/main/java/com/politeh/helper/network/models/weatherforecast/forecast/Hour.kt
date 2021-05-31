package com.politeh.helper.network.models.weatherforecast.forecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.politeh.helper.network.models.weatherforecast.WeatherCondition
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hour(
    @SerializedName("time") val time: String,
    @SerializedName("temp_c") val temperatureC: Float,
    @SerializedName("condition") val condition: WeatherCondition,
    @SerializedName("wind_kph") val windSpeedKph: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("precip_mm") val precipitationMm: Float,
    @SerializedName("feelslike_c") val feelsLikeC: Float,
    @SerializedName("chance_of_rain") val chanceOfRain: Int,
    @SerializedName("chance_of_snow") val chanceOfSnow: Int
): Parcelable