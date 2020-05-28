package com.jerm.ad340_helloworld

interface AppNavigator {
    fun navigateToForecastDetails(forecast: DailyForecast)
    fun navigateToCurrentForecast(zipcode: String)
    fun navigateToLocationEntry()
}