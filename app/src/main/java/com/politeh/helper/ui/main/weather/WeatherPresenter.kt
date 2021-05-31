package com.politeh.helper.ui.main.weather

import android.util.Log
import com.politeh.helper.network.models.searchinglocation.SearchingLocation
import com.politeh.helper.network.models.searchinglocation.SearchingLocationAPI
import com.politeh.helper.network.models.weatherforecast.WeatherForecast
import com.politeh.helper.network.models.weatherforecast.WeatherForecastAPI
import com.politeh.helper.network.models.weatherforecast.Location
import com.politeh.helper.network.models.weatherforecast.CurrentWeather
import com.politeh.helper.network.models.weatherforecast.forecast.Forecast
import com.politeh.helper.ui.base.mvp.presenters.BasePresenter
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate


class WeatherPresenter(
    private val view: WeatherContract.View,
    private val weatherForecastAPI: WeatherForecastAPI,
    private val searchingLocationAPI: SearchingLocationAPI,
    private val dateTimeStringFormatter: DateTimeStringFormatter
) : BasePresenter(), WeatherContract.ActionListener {


    private lateinit var location: Location
    private lateinit var currentWeather: CurrentWeather
    private lateinit var forecast: Forecast



    override fun init() {
        //TODO якщо немає інтернету - витягнути дані з БД
        updateWeather("Lviv")

    }


     override fun updateWeather(requestParameter: String) {
        weatherForecastAPI.getWeatherForecast(requestParameter).enqueue(object: Callback<WeatherForecast> {

            override fun onFailure(call: Call<WeatherForecast>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }

            override fun onResponse(
                call: Call<WeatherForecast>,
                response: Response<WeatherForecast>
            ) {
                if(response.code() == 400) {
                    return
                }

                location = response.body()!!.location
                currentWeather = response.body()!!.currentWeather
                forecast = response.body()!!.forecast

                updateScreen()
                //TODO закешувати в БД останній результат
            }
        })
    }


    private fun updateScreen() {

        val date = LocalDate.now()
        val dateString = dateTimeStringFormatter.getShortDateString(date)

        with(view) {
            setDate(
                dateTimeStringFormatter.getShortDateString(date),
                dateTimeStringFormatter.getDayDateString(date)
            )

            updateScreen(currentWeather, forecast)
        }
    }


    override fun onTextChange(text: String) {
        searchingLocationAPI.getSearchingLocationList(text).enqueue(object: Callback<List<SearchingLocation>> {
            override fun onFailure(call: Call<List<SearchingLocation>>, t: Throwable) {
                Log.d("TAG", t.toString())
            }


            override fun onResponse(
                call: Call<List<SearchingLocation>>,
                response: Response<List<SearchingLocation>>
            ) {

                if(response.code() == 400) {
                    return
                }

                if(response.body()!!.isEmpty()) {
                    return
                }

                val locationList = mutableListOf<String>()

                for(location in response.body()!!) {
                    locationList.add(location.name)
                }

                view.setAutoCompleteAdapter(locationList)
            }

        })
    }


}