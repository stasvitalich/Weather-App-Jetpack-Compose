package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun ListItem() {

    Card(
        modifier = Modifier
            .padding(top = 3.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        backgroundColor = BlueLight,
        elevation = 0.dp
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "12:00",
                    color = Color.Blue,
                    fontSize = 15.sp
                )
                Text(
                    text = "Sunny",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }

            Text(
                text = "25°",
                modifier = Modifier.align(Alignment.CenterVertically),
                color = Color.White,
                fontSize = 25.sp
            )

            AsyncImage(model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                contentDescription = "Android image",
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.CenterVertically)
                    .padding(end = 5.dp)
            )
        }
    }


}