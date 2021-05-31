package com.politeh.helper.network.models.weatherforecast.forecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>
): Parcelable