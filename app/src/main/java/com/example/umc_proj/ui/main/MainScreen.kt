package com.example.umc_proj.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.umc_proj.ui.buy.BuyScreen
import com.example.umc_proj.ui.component.BottomNavBar
import com.example.umc_proj.ui.home.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val selectedMenuBar = remember { mutableStateOf<Destination>(Destination.Home) }
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    LaunchedEffect(currentDestination) {
        selectedMenuBar.value = when (currentDestination?.route) {
            Destination.Home::class.qualifiedName -> Destination.Home
            Destination.Buy::class.qualifiedName -> Destination.Buy
            Destination.Wish::class.qualifiedName -> Destination.Wish
            Destination.Shop::class.qualifiedName -> Destination.Shop
            else -> Destination.Profile
        }
    }

    //네비게이션 화면 이동을 담당
    NavHost(
        navController = navController,
        startDestination = Destination.Home
    ) {
        // 제네릭으로 각 컴포저블의 경로를 나타냄
        composable<Destination.Home> {
            HomeScreen()
        }

        composable<Destination.Buy> {
            BuyScreen()
        }

        composable<Destination.Wish> {
            Text("위시")
        }

        composable<Destination.Shop> {
            Text("장바구니")
        }

        composable<Destination.Profile> {
            Text("프로")
        }
    }

    Column(
        modifier = Modifier
            .shadow(4.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomNavBar(
            selectedMenuBar = selectedMenuBar.value,
            onClickMenu = {
                navController.navigate(it) {
                    launchSingleTop = true
                    restoreState = true
                    // navigation 스택이 안쌓이도록
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                }
            }
        )
    }
}

// 경로들의 집합 보통은 String으로 하나 class로 관리가 편하여 직렬화 이용
sealed interface Destination {
    @Serializable
    data object Home: Destination
    @Serializable
    data object Buy: Destination
    @Serializable
    data object Wish: Destination
    @Serializable
    data object Shop: Destination
    @Serializable
    data object Profile: Destination
}
