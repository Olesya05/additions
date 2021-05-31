package com.politeh.helper.ui.main.weather

import android.content.Context
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.politeh.helper.HelperApplication
import com.politeh.helper.R
import com.politeh.helper.network.models.weatherforecast.CurrentWeather
import com.politeh.helper.network.models.weatherforecast.forecast.Forecast
import com.politeh.helper.network.models.weatherforecast.forecast.Hour
import com.politeh.helper.ui.base.fragments.BaseFragment
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import com.politeh.helper.ui.utils.StringProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_weather.*
import org.w3c.dom.Text
import javax.inject.Inject


class WeatherFragment: BaseFragment(R.layout.fragment_weather), WeatherContract.View {


    @Inject lateinit var presenter: WeatherPresenter
    @Inject lateinit var stringProvider: StringProvider
    @Inject lateinit var dateTimeStringFormatter: DateTimeStringFormatter

    private lateinit var forecastHoursAdapter: ForecastHoursAdapter




    override fun injectDependencies() {
        (requireContext().applicationContext as HelperApplication).getAppComponent()
            .createWeatherComponent()
            .create(this)
            .inject(this)
    }


    override fun init() {
        initRecycleView()
        presenter.init()

        initButtons()
    }


    private fun initRecycleView() = with(hourWeatherRv) {
        layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        adapter = ForecastHoursAdapter(listOf(), dateTimeStringFormatter, stringProvider).also {
            forecastHoursAdapter = it
        }
    }


    override fun setDate(date: String, day: String) {
        currentDateTv.text = date
        currentDayTv.text = day
    }


    override fun updateScreen(currentWeather: CurrentWeather, forecast: Forecast) {
        currentTemperatureTv.text = stringProvider.getString(R.string.current_weather_temperature, currentWeather.temperatureC)
        currentFeelsLikeTv.text = stringProvider.getString(R.string.current_weather_feels_like, currentWeather.feelsLikeC)

        Picasso.get().load("https:${currentWeather.condition.iconUrl}")
            .resize(100, 100)
            .into(currentIconImv)
        currentWeatherTv.text = currentWeather.condition.text

        currentWindSpeedTv.text = stringProvider.getString(R.string.current_weather_wind_speed, currentWeather.windSpeedKph)
        currentCloudTv.text = stringProvider.getString(R.string.current_weather_cloud_cover, currentWeather.cloudCover)

        currentHumidityTv.text = stringProvider.getString(R.string.current_weather_humidity, currentWeather.humidity)
        currentPrecipitationTv.text = stringProvider.getString(R.string.current_weather_precipitation, currentWeather.precipitationMm)

        val forecastHours: MutableList<Hour> = mutableListOf()

        for(index in forecast.forecastDays[0].hour.indices step 3) {
            forecastHours.add(forecast.forecastDays[0].hour[index])
        }

        forecastHoursAdapter.hoursForecast = forecastHours
        forecastHoursAdapter.notifyDataSetChanged()


    }


    private fun initButtons() {
        locationTv.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                presenter.onTextChange(text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

        locationTv.setOnItemClickListener { adapterView, view, position, _ ->
            presenter.updateWeather(adapterView.getItemAtPosition(position).toString())
            (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(view.applicationWindowToken, 0)
        }
    }


    override fun setAutoCompleteAdapter(locationList: MutableList<String>) {
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, locationList)
        locationTv.setAdapter(adapter)
        adapter.notifyDataSetChanged()
    }


}