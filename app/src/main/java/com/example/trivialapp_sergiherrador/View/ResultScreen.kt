package com.example.trivialapp_sergiherrador.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_sergiherrador.Model.goldenColor
import com.example.trivialapp_sergiherrador.ViewModel.GameViewModel
import com.example.trivialapp_sergiherrador.ViewModel.ResultViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel

@Composable
fun ResultScreen(
    navController: NavController,
    gameViewModel: GameViewModel,
    resultViewModel: ResultViewModel,
    settingsViewModel: SettingsViewModel
) {
    var textColor = if (settingsViewModel.darkMode) Color.White else Color.Black
    Column(Modifier.background(brush = settingsViewModel.getGradient())) {

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
                modifier = Modifier.padding(bottom = 16.dp),
                color = if (settingsViewModel.darkMode) Color.Black else Color.White
            )

            Text(
                text = "Aciertos: ${gameViewModel.aciertos}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = textColor
            )

            Text(
                text = "Fallos: ${gameViewModel.fallos}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = textColor
            )

            Button(
                onClick = { gameViewModel.resetGame(); navController.navigate("MenuScreen") },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                )
            ) {
                Text(
                    text = "Ir a Menu",
                    color = if (settingsViewModel.darkMode) Color.Black else Color.White
                )
            }
        }
    }
}
