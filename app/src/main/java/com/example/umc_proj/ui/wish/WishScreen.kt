package com.example.umc_proj.ui.wish

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun WishScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(44.dp))

        Text(
            modifier = Modifier
                .padding(start = 24.dp),
            text = "위시리스트",
            fontSize = 28.sp,
            color = Black
        )

        Spacer(modifier = Modifier.height(36.dp))

        //TODO 나중에 LazyGridColumn을 쓸 것?
        Column(
            modifier = Modifier
                .padding(start = 9.dp)
        ){
            Image(
                modifier = Modifier
                    .size(184.dp),
                painter = painterResource(R.drawable.img_nike),
                contentDescription = "신발 아이템"
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                modifier = Modifier
                    .padding(start = 14.dp),
                text = "Air Jordan 1 Mid",
                fontSize = 14.sp,
                color = Black
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                modifier = Modifier
                    .padding(start = 14.dp),
                text = "US\$125",
                fontSize = 14.sp,
                color = Black
            )
        }
    }
}