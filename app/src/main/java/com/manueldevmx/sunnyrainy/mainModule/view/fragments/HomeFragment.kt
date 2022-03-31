package com.manueldevmx.sunnyrainy.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.manueldevmx.sunnyrainy.databinding.FragmentHomeBinding
import com.manueldevmx.sunnyrainy.mainModule.model.weather.Current
import com.manueldevmx.sunnyrainy.mainModule.model.weather.OneCallEntity
import com.manueldevmx.sunnyrainy.home.adapters.PredictionCardAdapter
import java.text.SimpleDateFormat
import java.util.*

private const val ONE_CALL_ENTITY = "oneCallEntity"

class HomeFragment : Fragment() {
    private var oneCallEntity: OneCallEntity? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        arguments?.let {
            oneCallEntity = it.getSerializable(ONE_CALL_ENTITY) as OneCallEntity
        }
        formatResponse(oneCallEntity)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param oneCallEntity Weather data show ui
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(oneCallEntity: OneCallEntity) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ONE_CALL_ENTITY, oneCallEntity)
                }
            }
    }

    private fun initPredictionsRecyclerView(predictions: List<Current>){
        binding.recyclerViewNextHours.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = PredictionCardAdapter(this.context, predictions )
        }
    }


    private fun formatResponse(oneCallEntity: OneCallEntity?) {
        if (oneCallEntity != null) {
            val current = oneCallEntity.current
            val cityName = oneCallEntity.city?.name
            val countryCode = oneCallEntity.city?.country
            val address = "$cityName, $countryCode"
            val temp = "${current.temp}°"
            val sorterPredictions = oneCallEntity.hourly.sortedByDescending {it.temp}
            val minTemp = "Min: ${sorterPredictions.last().temp.toInt()}°"
            val maxTemp = "Max: ${sorterPredictions.first().temp.toInt()}°"
            val wind = "${current.wind} km/h"
            val pressure = "${current.pressure} mb"
            val humidity = "${current.humidity}%"
            val icon = current.weather.first().icon.replace('n', 'd')
            val iconResource = resources.getIdentifier("ic_weather_$icon", "drawable", activity?.applicationContext?.packageName)
            val description = current.weather.first().description.uppercase()
            val dateFormatter = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
            val updatedAt = dateFormatter.format(Date(oneCallEntity.current.dt*1000))

            binding.apply {
                textViewDate.text = updatedAt
                textViewCity.text = address
                textViewWeatherMaxTemp.text = maxTemp
                textViewWeatherMinTemp.text = minTemp
                imageWeather.load(iconResource)
                textViewDescription.text = description
                textViewWeatherCurrentTemp.text = temp
                pressureValue.text = pressure
                humidityValue.text = humidity
                windValue.text = wind
            }
            initPredictionsRecyclerView(oneCallEntity.hourly)
        }
    }
}