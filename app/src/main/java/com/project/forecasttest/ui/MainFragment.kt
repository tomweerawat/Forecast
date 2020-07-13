package com.project.forecasttest.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.project.forecasttest.R
import com.project.forecasttest.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.current_weather_fragment.*
import timber.log.Timber
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment: Fragment() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val q= "Bangkok,th"
        val appid = "94c9b5acca79f8a1595cbf96c0bdf60e"

        viewModel.loadWeather(q,appid)
        viewModel.list.observe(viewLifecycleOwner, Observer {
            group_loading.visibility = View.GONE
            textView_visibility.text = "Visibility: ${it.visibility ?: "0"} km"
            textView_wind.text = "Wind: SE, ${it.wind.speed} m/s"
            textView_temperature.text = "${it.main.temp}°C"
            textView_feels_like_temperature.text = "Feels like ${it.main.feels_like}°F"
            it.weather.forEach { f ->
                Log.e("Hello", "Hello$"+f.description)
                textView_condition.text = "${it.name}\n${f.main}\t${f.description}"
            }

        })
    }

    private fun celsius(value: Double): Double{
        val celsius =( (value  -  32  ) *  5)/9
        return celsius
    }
}