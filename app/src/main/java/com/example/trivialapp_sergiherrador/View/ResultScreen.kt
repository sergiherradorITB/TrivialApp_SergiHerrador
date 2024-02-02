package com.example.trivialapp_sergiherrador.View

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
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
            resultViewModel.pillarNota(gameViewModel, settingsViewModel)
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
                text = "Nota: ${resultViewModel.textoNota()}",
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

            Text(
                text = "Dificultad: ${settingsViewModel.dificultad}",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = textColor
            )
            Button(
                onClick = { gameViewModel.resetGame(); navController.navigate("MenuScreen") },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.5f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                )
            ) {
                Text(
                    text = "Ir a Menu",
                    color = if (settingsViewModel.darkMode) Color.Black else Color.White
                )
            }
            ShareButton(
                text = "Mi resultado es:\nTienes: ${gameViewModel.aciertos} aciertos\nTienes: ${gameViewModel.fallos} fallos\nTienes ${resultViewModel.textoNota()} nota",
                context = LocalContext.current,
                settingsViewModel
            )

        }
    }
}

@Composable
fun ShareButton(text: String, context: Context, settingsViewModel: SettingsViewModel) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)

    Button(
        modifier = Modifier
            .fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
        ),
        onClick = {
            ContextCompat.startActivity(context, shareIntent, null)
        },
    ) {
        Text(
            "Share",
            color = if (settingsViewModel.darkMode) Color.Black else Color.White
        )
    }
}