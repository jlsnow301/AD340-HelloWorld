package com.jerm.ad340_helloworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForecast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipcode: String){
        val randomValues = List(12){
            Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map { temp -> DailyForecast(temp, getTempDescription(temp))
        }

        _weeklyForecast.value = forecastItems
    }

    private fun getTempDescription(temp: Float) : String {
        return when(temp){
            in Float.MIN_VALUE.rangeTo(0f) -> "Anything below 0 doesn't make sense"
            in Float.MIN_VALUE.rangeTo(32f) -> "Freezing!"
            in Float.MIN_VALUE.rangeTo(55f) -> "Dreary"
            in Float.MIN_VALUE.rangeTo(65f) -> "Quite nice"
            in Float.MIN_VALUE.rangeTo(80f) -> "Muggy"
            in Float.MIN_VALUE.rangeTo(90f) -> "Sauna"
            in Float.MIN_VALUE.rangeTo(100f) -> "Sweltering"
            in Float.MIN_VALUE.rangeTo(Float.MAX_VALUE) -> "Volcanic Activity"
            else -> "Does not compute"
        }
    }
}