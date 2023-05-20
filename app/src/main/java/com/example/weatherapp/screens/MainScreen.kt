package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.BlueLight
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable

fun MainScreen() {
    Image(
        painter = painterResource(id = R.mipmap.skybackground),
        contentDescription = "Sky background",
        modifier = Modifier
            .alpha(0.5f)
            .fillMaxSize(),
        contentScale = ContentScale.Crop

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = BlueLight,
            shape = RoundedCornerShape(10.dp),

            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "20 May 2023",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontSize = 15.sp,
                        color = Color.White
                    )

                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                        contentDescription = "Image of current weather",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 5.dp)
                    )
                }

                Text(
                    text = "Pavlodar",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,

                    )

                Text(
                    text = "22°C",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )

                Text(
                    text = "Sunny",
                    fontSize = 20.sp,
                    color = Color.White

                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Find another location",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = "Wind ~ 31.0 k/ph",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White
                    )

                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.synch),
                            contentDescription = "Update data",
                            tint = Color.White
                        )
                    }


                }
            }
        }
    }
}