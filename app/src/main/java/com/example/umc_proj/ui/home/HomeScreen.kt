package com.example.umc_proj.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umc_proj.R
import com.example.umc_proj.ui.theme.Black
import com.example.umc_proj.ui.theme.Gray600

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 19.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            modifier = Modifier
                .padding(start = 24.dp),
            text = "Discover",
            fontSize = 28.sp,
            color = Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        //TODO 나중에 TimeFormatter를 이용해서 현재 날짜로 수정하는 과제일듯..?
        Text(
            modifier = Modifier
                .padding(start = 24.dp),
            text = "9월 4일 목요일",
            fontSize = 16.sp,
            color = Gray600
        )

        Spacer(modifier = Modifier.height(50.dp))

        //aspectRatio는 view의 비율을 나타냄
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(375f/500f),
            painter = painterResource(R.drawable.img_home),
            contentDescription = null
        )
    }
}