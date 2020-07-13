package com.project.forecasttest.repository

import com.project.forecasttest.data.model.Weather
import io.reactivex.Observable

interface IWeatherUseCase{
    fun getWeather(q: String,APPID: String): Observable<Weather>
}
class WeatherUseCaseImpl(private val repo: IWeatherRepository): IWeatherUseCase {
    override fun getWeather(q: String, APPID: String): Observable<Weather> {
        return repo.getWeather(q,APPID).map { it }
    }
}