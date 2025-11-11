package com.example.umc_proj.ui.buy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.umc_proj.ui.theme.Black
import com.example.umc_proj.ui.theme.Gray600
import kotlinx.serialization.Serializable

@Composable
fun BuyScreen(
    navController: NavHostController = rememberNavController(),
) {
    val selectedTapBar = remember { mutableStateOf<BuyDestination>(BuyDestination.All) }
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    LaunchedEffect(currentDestination) {
        selectedTapBar.value = when (currentDestination?.route) {
            BuyDestination.All::class.qualifiedName -> BuyDestination.All
            BuyDestination.Top::class.qualifiedName -> BuyDestination.Top
            else -> BuyDestination.Sale
        }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 19.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .padding(start = 9.dp)
        ) {
            TapMenuItem(
                selectDestination = selectedTapBar.value,
                tapDestination = BuyDestination.All,
                onClickTap = {
                    navController.navigate(it) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                }
            )

            TapMenuItem(
                selectDestination = selectedTapBar.value,
                tapDestination = BuyDestination.Top,
                onClickTap = {
                    navController.navigate(it) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                }
            )

            TapMenuItem(
                selectDestination = selectedTapBar.value,
                tapDestination = BuyDestination.Sale,
                onClickTap = {
                    navController.navigate(it) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                }
            )
        }


        NavHost(
            navController = navController,
            startDestination = BuyDestination.All
        ) {
            composable<BuyDestination.All> {
                Text("전체화면")
            }

            composable<BuyDestination.Top> {
                Text("탑 화면")
            }

            composable<BuyDestination.Sale> {
                Text("세일화면")
            }
        }
    }
}

@Composable
private fun TapMenuItem(
    selectDestination: BuyDestination,
    tapDestination: BuyDestination,
    onClickTap: (BuyDestination) -> Unit = {}
){
    val text = when (tapDestination) {
        BuyDestination.All -> "전체"
        BuyDestination.Sale -> "Tops & T-Shirts"
        BuyDestination.Top -> "sale"
    }
    val color = if (selectDestination == tapDestination) Black else Gray600
    Column(
        modifier = Modifier
            .clickable {
                onClickTap(tapDestination)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 20.dp),
            text = text,
            color = color,
            fontSize = 16.sp
        )

        if (selectDestination == tapDestination) {
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .background(color = color),
            )
        }
    }
}

sealed interface BuyDestination {
    @Serializable
    data object All: BuyDestination
    @Serializable
    data object Top: BuyDestination
    @Serializable
    data object Sale: BuyDestination
}