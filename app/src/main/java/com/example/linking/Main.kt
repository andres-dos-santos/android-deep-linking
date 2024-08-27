package com.example.linking

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController = navController) }
        composable(
            "Detail/{userId}/{userName}",
            deepLinks = listOf(navDeepLink {
                uriPattern = "https://www.navtest.com/{userId}/{userName}"
            })
        ) {
            Detail(
                navController = navController,
                userId = it.arguments?.getString("userId"),
                userName = it.arguments?.getString("userName")
            )
        }
    }
}