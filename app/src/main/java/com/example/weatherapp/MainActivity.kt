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
import com.example.weatherapp.screens.MainCard
import com.example.weatherapp.screens.Tablayout

import com.example.weatherapp.ui.theme.WeatherAppTheme

const val API_KEY = "1c8327b6f4194789a90154340231805"

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
        {
            response ->
        },

        {
            val message = "Error"
        }
    )

    queue.add(request)
}
