package com.example.trivialapp_sergiherrador.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
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
    settingsViewModel: SettingsViewModel,
    windowSize: WindowSizeClass
) {
    val currentQuestion = gameViewModel.getCurrentQuestion(settingsViewModel)
    val respuestas = currentQuestion.answers

    // Verificar si el juego ha terminado
    if (gameViewModel.gameFinished) {
        // Navegar a la pantalla de resultados
        navController.navigate("ResultScreen")
    } else {
        // Mostrar la pantalla del juego normalmente
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(brush = settingsViewModel.getGradient())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Round " + gameViewModel.actualRound + "/" + settingsViewModel.rondas,
                    color = if (settingsViewModel.darkMode) Color.White else Color.Black

                )
                Text(
                    text = currentQuestion.questionText,
                    modifier = Modifier.fillMaxHeight(0.6f),
                    fontSize = 20.sp,
                    color = if (settingsViewModel.darkMode) Color.White else Color.Black
                )

            }
            // Main Content
            if (windowSize.widthSizeClass >= WindowWidthSizeClass.Medium) {
                Row(modifier = Modifier.fillMaxSize()) {
                    // Image on the left
                    Image(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .scale(1f, 1f)
                            .fillMaxHeight(1f),
                        painter = painterResource(id = currentQuestion.questionImage),
                        contentDescription = currentQuestion.questionName
                    )

                    // Questions Column
                    Column(
                        modifier = Modifier
                            .weight(0.6f)
                            .fillMaxHeight(1f)
                            .padding(horizontal = 16.dp),
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
                            for (i in 0 until 2) {
                                Button(
                                    onClick = {
                                        gameViewModel.checkAnswer(
                                            respuestas[i],
                                            settingsViewModel
                                        )
                                    },
                                    modifier = Modifier
                                        .weight(0.4f)
                                        .padding(end = 8.dp)
                                ) {
                                    Text(
                                        text = respuestas[i].answerText,
                                        color = if (settingsViewModel.darkMode) Color.White else Color.Black
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            for (i in 2 until 4) {
                                Button(
                                    onClick = {
                                        gameViewModel.checkAnswer(
                                            respuestas[i],
                                            settingsViewModel
                                        )
                                    },
                                    modifier = Modifier
                                        .weight(0.4f)
                                        .padding(end = 8.dp)
                                ) {
                                    Text(
                                        text = respuestas[i].answerText,
                                        color = if (settingsViewModel.darkMode) Color.White else Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f),
                    contentAlignment = Alignment.Center

                )
                {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(1f, 1f),
                        painter = painterResource(id = currentQuestion.questionImage),
                        contentDescription = currentQuestion.questionName
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.75f)
                        .padding(top = 16.dp)
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
                            onClick = {
                                gameViewModel.checkAnswer(
                                    respuestas[0],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = respuestas[0].answerText,
                                color = if (settingsViewModel.darkMode) Color.White else Color.Black
                            )
                        }
                        Button(
                            onClick = {
                                gameViewModel.checkAnswer(
                                    respuestas[1],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = respuestas[1].answerText,
                                color = if (settingsViewModel.darkMode) Color.White else Color.Black
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                gameViewModel.checkAnswer(
                                    respuestas[2],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = respuestas[2].answerText,
                                color = if (settingsViewModel.darkMode) Color.White else Color.Black
                            )
                        }
                        Button(
                            onClick = {
                                gameViewModel.checkAnswer(
                                    respuestas[3],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = respuestas[3].answerText,
                                color = if (settingsViewModel.darkMode) Color.White else Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}