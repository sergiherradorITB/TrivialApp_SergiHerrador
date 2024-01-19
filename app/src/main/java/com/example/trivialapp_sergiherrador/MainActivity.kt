package com.example.trivialapp_sergiherrador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_sergiherrador.View.GameScreen
import com.example.trivialapp_sergiherrador.View.MenuScreen
import com.example.trivialapp_sergiherrador.View.ResultScreen
import com.example.trivialapp_sergiherrador.View.SettingsScreen
import com.example.trivialapp_sergiherrador.ViewModel.GameViewModel
import com.example.trivialapp_sergiherrador.ViewModel.MenuViewModel
import com.example.trivialapp_sergiherrador.ViewModel.ResultViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel
import com.example.trivialapp_sergiherrador.ui.theme.TrivialApp_SergiHerradorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val menuMainViewModel by viewModels<MenuViewModel>()
        val gameMainViewModel by viewModels<GameViewModel>()
        val settingsViewModel by viewModels<SettingsViewModel>()
        val resultViewModel by viewModels<ResultViewModel>()


        super.onCreate(savedInstanceState)
        setContent {
            TrivialApp_SergiHerradorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.MenuScreen.route
                    ) {
                        composable(Routes.MenuScreen.route) { MenuScreen(navigationController, menuMainViewModel, settingsViewModel) }
                        composable(Routes.SettingsScreen.route) { SettingsScreen(navigationController, settingsViewModel) }
                        composable(Routes.GameScreen.route) { GameScreen(navigationController,gameMainViewModel ,settingsViewModel) }
                        composable(Routes.ResultScreen.route) { ResultScreen(
                            navController = navigationController,
                            gameMainViewModel,
                            resultViewModel,
                            settingsViewModel
                        )}

                        /*composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }*/
                    }

                }
            }
        }
    }
}
