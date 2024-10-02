package com.example.dailypals.android

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailypals.android.screens.AboutScreen
import com.example.dailypals.android.screens.ArticlesScreen
import com.example.dailypals.android.screens.Screen
import com.example.dailypals.articles.ArticlesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()
    Scaffold {
        AppNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            navController = navController,
            articlesViewModel = articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    articlesViewModel: ArticlesViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Articles.route
    ) {
        composable(Screen.Articles.route) {
            ArticlesScreen(articlesViewModel) {
                navController.navigate(Screen.About.route)
            }
        }
        composable(Screen.About.route) {
            AboutScreen() {
                navController.popBackStack()
            }
        }
    }
}