package com.politeh.helper.network.models.weatherforecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrentWeather(
    @SerializedName("temp_c") val temperatureC: Float,
    @SerializedName("condition") val condition: WeatherCondition,
    @SerializedName("wind_kph") val windSpeedKph: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("precip_mm") val precipitationMm: Float,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("cloud") val cloudCover: Int,
    @SerializedName("feelslike_c") val feelsLikeC: Float,
    @SerializedName("uv") val uv: Float
): Parcelable