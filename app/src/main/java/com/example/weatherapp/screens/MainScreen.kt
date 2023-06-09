package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.ui.theme.BlueLight
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable

fun MainCard() {

    Column(
        modifier = Modifier
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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tablayout(daysList: MutableState<List<WeatherModel>>) {

    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            indicator = { position ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(
                        pagerState, position
                    )
                )
            },
            backgroundColor = BlueLight,
            contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(selected = false, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },

                    text = {
                        Text(text = text, color = Color.White)
                    })

            }
        }

        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        )
        { index ->
            
            LazyColumn(modifier = Modifier.fillMaxSize().padding(start = 5.dp, end = 5.dp))
            {
                itemsIndexed(
                    daysList.value
                ){
                    _, item -> ListItem(item)
                }


            }
        }
    }
}

