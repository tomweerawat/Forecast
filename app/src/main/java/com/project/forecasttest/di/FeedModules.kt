package com.project.forecasttest.di

import com.project.forecasttest.repository.IWeatherRepository
import com.project.forecasttest.repository.IWeatherUseCase
import com.project.forecasttest.repository.WeatherRepositoryImpl
import com.project.forecasttest.repository.WeatherUseCaseImpl
import com.project.forecasttest.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val feedModule = module {

    factory<IWeatherUseCase> { WeatherUseCaseImpl(get()) }

    factory<IWeatherRepository> { WeatherRepositoryImpl(get()) }

    viewModel { WeatherViewModel(get()) }

}