package com.example.umc_proj.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umc_proj.R
import com.example.umc_proj.ui.main.Destination
import com.example.umc_proj.ui.theme.Black
import com.example.umc_proj.ui.theme.Gray600
import com.example.umc_proj.ui.theme.White

@Composable
fun BottomNavBar(
    selectedMenuBar: Destination,
    onClickMenu: (Destination) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .background(White)
            .padding(bottom = 16.dp, top = 8.dp)
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarMenuItem(
            itemName = Destination.Home,
            selectedMenuBar = selectedMenuBar,
            onClickMenu = onClickMenu
        )

        BottomBarMenuItem(
            itemName = Destination.Buy,
            selectedMenuBar = selectedMenuBar,
            onClickMenu = onClickMenu
        )

        BottomBarMenuItem(
            itemName = Destination.Wish,
            selectedMenuBar = selectedMenuBar,
            onClickMenu = onClickMenu
        )

        BottomBarMenuItem(
            itemName = Destination.Shop,
            selectedMenuBar = selectedMenuBar,
            onClickMenu = onClickMenu
        )

        BottomBarMenuItem(
            itemName = Destination.Profile,
            selectedMenuBar = selectedMenuBar,
            onClickMenu = onClickMenu
        )
    }
}


// 아이템 재사용을 위하여 따로 정의 (ViewHolder 같은 느낌)
@Composable
fun BottomBarMenuItem(
    itemName: Destination,
    selectedMenuBar: Destination,
    onClickMenu: (Destination) -> Unit = {}
) {
    val icon = when (itemName) {
        Destination.Buy -> R.drawable.ic_buy
        Destination.Home -> R.drawable.ic_home
        Destination.Profile -> R.drawable.ic_profile
        Destination.Shop -> R.drawable.ic_shop
        Destination.Wish -> R.drawable.ic_wish
    }
    val text = when (itemName) {
        Destination.Buy -> "구매하기"
        Destination.Home -> "홈"
        Destination.Profile -> "마이페이지"
        Destination.Shop -> "장바구니"
        Destination.Wish -> "위시리스트"
    }
    val color = if (itemName == selectedMenuBar) Black else Gray600
    Column(
        modifier = Modifier
            .clickable {
                onClickMenu(itemName)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = "icon",
            colorFilter = ColorFilter.tint(color)
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = text,
            color = color,
            fontSize = 10.sp
        )
    }
}

