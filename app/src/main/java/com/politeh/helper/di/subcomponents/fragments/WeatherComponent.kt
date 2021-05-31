package com.politeh.helper.di.subcomponents.fragments

import com.politeh.helper.network.models.searchinglocation.SearchingLocationAPI
import com.politeh.helper.network.models.weatherforecast.WeatherForecastAPI
import com.politeh.helper.ui.main.weather.WeatherContract
import com.politeh.helper.ui.main.weather.WeatherFragment
import com.politeh.helper.ui.main.weather.WeatherPresenter
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [WeatherComponent.ComponentModule::class])
interface WeatherComponent {


    fun inject(fragment: WeatherFragment)


    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance view: WeatherContract.View): WeatherComponent
    }


    @Module
    object ComponentModule {

        @Provides
        fun provideWeatherPresenter(
            view: WeatherContract.View,
            weatherForecastAPI: WeatherForecastAPI,
            searchingLocationAPI: SearchingLocationAPI,
            dateTimeStringFormatter: DateTimeStringFormatter
        ): WeatherPresenter {
            return WeatherPresenter(
                view,
                weatherForecastAPI,
                searchingLocationAPI,
                dateTimeStringFormatter
            )
        }
    }


}