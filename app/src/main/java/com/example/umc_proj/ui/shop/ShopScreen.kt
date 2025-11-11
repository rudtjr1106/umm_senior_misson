package com.example.umc_proj.ui.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umc_proj.R
import com.example.umc_proj.ui.theme.Black
import com.example.umc_proj.ui.theme.Gray600
import com.example.umc_proj.ui.theme.White

@Composable
fun ShopScreen(
    onClickBuy: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(225.dp))

        Image(
            painter = painterResource(R.drawable.ic_shop_circle),
            contentDescription = "동그라미"
        )

        Spacer(modifier = Modifier.height(27.dp))

        Text(
            text = "장바구니가 비어 있습니다.\n" +
                    "제품을 추가하면 여기에 표시됩니다.",
            fontSize = 14.sp,
            color = Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .clickable {
                    onClickBuy()
                }
                .padding(horizontal = 40.dp)
                .fillMaxWidth()
                .background(color = Black, shape = RoundedCornerShape(100.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 16.dp),
                text = "주문하기",
                color = White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(83.dp))
    }
}