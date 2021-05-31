package com.politeh.helper.network.models.searchinglocation

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchingLocationAPI {


    @GET("/v1/search.json?key=3ebf40eb74864e3ea94135724201210")
    fun getSearchingLocationList(@Query("q") searchingString: String): Call<List<SearchingLocation>>
}