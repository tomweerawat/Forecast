package com.project.forecasttest.repository

import com.project.forecasttest.data.model.Weather
import com.project.forecasttest.data.network.IWeatherApi
import io.reactivex.Observable

interface IWeatherRepository{
    fun getWeather(q: String,APPID: String):Observable<Weather>
}
class WeatherRepositoryImpl(private val api: IWeatherApi): IWeatherRepository {
    override fun getWeather(q: String, APPID: String): Observable<Weather> {
        return api.getWeather(q,APPID)
    }

}