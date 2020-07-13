package com.project.forecasttest.di

import com.project.forecasttest.data.builder.OkHttpBuilder
import com.project.forecasttest.data.builder.RetrofitBuilder
import com.project.forecasttest.data.network.IWeatherApi
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

private const val BASE_URL = "https://api.openweathermap.org/"

val networkModule = module {

    single { OkHttpBuilder().build() }

    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single { RetrofitBuilder(get(), get()) }

    single<IWeatherApi> { get<RetrofitBuilder>().build(BASE_URL) }
}