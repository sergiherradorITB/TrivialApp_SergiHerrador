package com.example.trivialapp_sergiherrador.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_sergiherrador.ViewModel.GameViewModel
import com.example.trivialapp_sergiherrador.ViewModel.ResultViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel

@Composable
fun ResultScreen(
    navController: NavController,
    gameViewModel: GameViewModel,
    totalQuestions: SettingsViewModel,
    resultViewModel: ResultViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Resultados",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Aciertos: $correctAnswers",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Fallos: ${ - correctAnswers}",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = { navController.navigate("MenuScreen") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Ir a Menu")
        }
    }
}
