package com.project.forecasttest.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.project.forecasttest.data.model.Weather
import com.project.forecasttest.utils.extension.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import androidx.lifecycle.ViewModel
import com.project.forecasttest.repository.IWeatherUseCase
import com.project.forecasttest.utils.UnitSystem

class WeatherViewModel(private val getweather: IWeatherUseCase) : ViewModel() {

    var list = MutableLiveData<Weather>()
    private val compositeDisposable = CompositeDisposable()


    fun loadWeather(q:String,APPID: String) {
        getweather.getWeather(q,APPID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveWeatherStart() }
            .doOnTerminate { onRetrieveWeatherFinish() }
            .subscribe({ articles ->
                list.value = articles
                onRetrieveWeatherSuccess(list)
            },
                {
                    onRetrieveWeatherError()
                }
            )
            .addTo(compositeDisposable)
    }

    private fun onRetrieveWeatherError() {

    }

    private fun onRetrieveWeatherStart() {
    }

    private fun onRetrieveWeatherFinish() {

    }

    private fun onRetrieveWeatherSuccess(value: MutableLiveData<Weather>) {

    }

}