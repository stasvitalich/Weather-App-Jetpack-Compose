package com.example.weatherapp

import android.app.DownloadManager.Request
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.screens.MainCard
import com.example.weatherapp.screens.Tablayout

import com.example.weatherapp.ui.theme.WeatherAppTheme
import org.json.JSONObject

const val API_KEY = "bde2c49d95c84ceca2c90923232505 "

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                getData("Pavlodar", this)
                Image(
                    painter = painterResource(id = R.mipmap.skybackground),
                    contentDescription = "Sky background",
                    modifier = Modifier
                        .alpha(0.5f)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop

                )

                Column {
                    MainCard()
                    Tablayout()
                }

            }
        }
    }
}

// The function for getting data from API

private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
            API_KEY +
            "&q=$city" +
            "&days=" +
            "3" +
            "&aqi=no&alerts=no"

    val queue = Volley.newRequestQueue(context)
    val request = StringRequest(
        com.android.volley.Request.Method.GET,
        url,
        { response ->
        },

        {
            val message = "Error"
        }
    )

    queue.add(request)
}

private fun getWeatherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) {
        return listOf()
    }
    val list = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location").getString("name")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")

    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                item.getString("date"),
                "",
                item.getJSONObject("day").getJSONObject("condition").getString("text"),
                item.getJSONObject("day").getJSONObject("condition").getString("icon"),
                item.getJSONObject("day").getString("maxtemp_c"),
                item.getJSONObject("day").getString("mintemp_c"),
                item.getJSONArray("hour").toString()
            )
        )
    }
    list[0] = list[0].copy(
        time = mainObject.getJSONObject("current").getString("last_updated"),
        currentTemp = mainObject.getJSONObject("current").getString("temp_c")
    )
    return list
}
