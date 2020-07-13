package com.project.forecasttest.data.network

import com.project.forecasttest.data.model.Weather
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface IWeatherApi {

    @POST("data/2.5/weather")
    fun getWeather(@Query("q") q: String, @Query("APPID") APPID: String):  Observable<Weather>

}