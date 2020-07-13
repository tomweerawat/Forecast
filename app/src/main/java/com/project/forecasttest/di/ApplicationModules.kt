package com.project.forecasttest.di

import com.project.forecasttest.utils.UserPreference
import com.project.forecasttest.utils.IUserPreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val applicationModule = module {
    factory<IUserPreference> { UserPreference(androidContext()) }
}
