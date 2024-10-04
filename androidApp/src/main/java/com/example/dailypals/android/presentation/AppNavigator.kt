package com.example.dailypals.android.presentation

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
import com.example.dailypals.android.presentation.screens.AboutScreen
import com.example.dailypals.android.presentation.screens.ArticlesScreen
import com.example.dailypals.android.presentation.screens.Screen
import com.example.dailypals.articles.presentation.ArticlesViewModel
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    Scaffold {
        AppNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            navController = navController
        )
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    articlesViewModel: ArticlesViewModel = getViewModel()
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