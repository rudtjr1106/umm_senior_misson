package com.example.umc_proj.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home
    ) {
        composable<Destination.Home> {

        }

        composable<Destination.Buy> {

        }

        composable<Destination.Wish> {

        }

        composable<Destination.Shop> {

        }

        composable<Destination.Profile> {

        }
    }
}

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
