package com.example.trivialapp_sergiherrador.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.trivialapp_sergiherrador.ViewModel.GameViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel

@Composable
fun GameScreen(
    navController: NavHostController,
    gameViewModel: GameViewModel,
    settingsViewModel: SettingsViewModel
) {
    val currentQuestion = gameViewModel.getCurrentQuestion(settingsViewModel)
    val respuestas = currentQuestion.answers

    // Verificar si el juego ha terminado
    if (gameViewModel.gameFinished) {
        // Navegar a la pantalla de resultados
        navController.navigate("ResultScreen")
    } else {
        // Mostrar la pantalla del juego normalmente
        Column(modifier = Modifier.padding(16.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Round " + gameViewModel.actualRound + "/" + settingsViewModel.rondas)
                Text(
                    text = currentQuestion.questionText,
                    modifier = Modifier.fillMaxHeight(0.6f),
                    fontSize = 20.sp
                )
                Image(
                    modifier = Modifier.fillMaxSize(1f),
                    painter = painterResource(id = currentQuestion.questionImage),
                    contentDescription = currentQuestion.questionName
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.75f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Utilizar los textos de las respuestas en los botones
                    Button(
                        onClick = { gameViewModel.checkAnswer(respuestas[0], settingsViewModel) },
                        modifier = Modifier
                            .weight(0.4f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = respuestas[0].answerText)
                    }
                    Button(
                        onClick = { gameViewModel.checkAnswer(respuestas[1],settingsViewModel) },
                        modifier = Modifier
                            .weight(0.4f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = respuestas[1].answerText)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { gameViewModel.checkAnswer(respuestas[2],settingsViewModel) },
                        modifier = Modifier
                            .weight(0.4f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = respuestas[2].answerText)
                    }
                    Button(
                        onClick = { gameViewModel.checkAnswer(respuestas[3],settingsViewModel) },
                        modifier = Modifier
                            .weight(0.4f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = respuestas[3].answerText)
                    }
                }
            }

        }
    }
}