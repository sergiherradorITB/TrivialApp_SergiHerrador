package com.example.trivialapp_sergiherrador.View

import android.graphics.LinearGradient
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.trivialapp_sergiherrador.R
import com.example.trivialapp_sergiherrador.Routes
import com.example.trivialapp_sergiherrador.ViewModel.MenuViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController, menuMainViewModel: MenuViewModel, settingsViewModel: SettingsViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(brush = settingsViewModel.getGradient()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo con padding
        Image(
            painter = painterResource(id = R.drawable.itblogoapp),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .padding(16.dp)
        )
        val context = LocalContext.current

        // Botón de Play
        Button(
            onClick = { navController.navigate("GameScreen") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(top = 20.dp)
        ) {
            Text(text = "Play", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        // Botón de Settings
        Button(
            onClick = { navController.navigate("SettingsScreen") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            modifier = Modifier
                .fillMaxWidth(0.5f),
        ) {
            Text(text = "Settings", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        // Botón de Help
        Button(
            onClick = {
                menuMainViewModel.modifyShow(true) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            modifier = Modifier
                .fillMaxWidth(0.5f),
        ) {
            Text(text = "Help", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        MyDialog(menuMainViewModel.show) { menuMainViewModel.modifyShow(false) }
    }
}

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxHeight(0.9f)
                    .fillMaxHeight(0.7f)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Bienvenido al Trivial ITB hecho por Sergi \n \n" +
                            "Por defecto los parametros son: \n" +
                            "Dificultad: MEDIUM, Rondas: 10, Tiempo por ronda 10 segundos, \n \n" +
                            "Tienes que ir a ajustes para cambiar parametros \n" +
                            "Easy: Las preguntas son más sencillas \n" +
                            "Medium: Las preguntas son de dificultad media \n" +
                            "Hard:  Las preguntas son de dificultad díficil\n \n" +
                            "Parametros que puedes cambiar: \n" +
                            "Dificultad, Las rondas, Tiempo por ronda, Dark Mode",
                    fontSize = 15.sp
                )

            }
        }
    }
}
