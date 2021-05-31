package com.politeh.helper.network.models.weatherforecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String,
    @SerializedName("country") val country: String,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("tz_id") val timeZoneName: String,
    @SerializedName("localtime_epoch") val localTimeEpoch: Int,
    @SerializedName("localtime") val localTime: String
): Parcelable