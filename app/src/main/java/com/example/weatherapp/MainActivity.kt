package com.example.weatherapp

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
import com.example.weatherapp.screens.MainCard
import com.example.weatherapp.screens.Tablayout

import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {

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

private fun getData(city: String, context: Context){

}
