package com.example.trivialapp_sergiherrador.View

import android.graphics.Insets.add
import android.os.Build.VERSION.SDK_INT
import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.OriginalSize
import com.example.trivialapp_sergiherrador.Model.goldenColor
import com.example.trivialapp_sergiherrador.ViewModel.GameViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel
import java.nio.file.Files.size


// ...

@Composable
fun GameScreen(
    navController: NavHostController,
    gameViewModel: GameViewModel,
    settingsViewModel: SettingsViewModel,
    windowSize: WindowSizeClass
) {

    var currentQuestion = gameViewModel.currentQuestion
    var respuestas = currentQuestion.answers

    // Verificar si el juego ha terminado
    if (gameViewModel.gameFinished) {
        navController.navigate("ResultScreen")
        gameViewModel.cancelTimer()
    } else {
        LaunchedEffect(gameViewModel.actualRound) {
            gameViewModel.startTimer(settingsViewModel)
        }
        gameViewModel.startGame(settingsViewModel)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(brush = settingsViewModel.getGradient())
                .fillMaxWidth()
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
                    modifier = Modifier
                        .fillMaxHeight(0.6f),
                    fontSize = 20.sp,
                    color = if (settingsViewModel.darkMode) Color.White else Color.Black
                )

            }
            // Main Content
            if (windowSize.widthSizeClass >= WindowWidthSizeClass.Medium) {
                Row(modifier = Modifier.fillMaxSize()) {
                    // Image on the left
                    GifImage(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .scale(1f, 1f)
                            .fillMaxHeight(1f)
                            .aspectRatio(1f),
                        imageID = currentQuestion.questionImage
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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Utilizar los textos de las respuestas en los botones
                            for (i in 0 until 4) {
                                Button(
                                    onClick = {
                                        respuestas = currentQuestion.answers
                                        gameViewModel.checkAnswer(
                                            respuestas[i],
                                            settingsViewModel
                                        )
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 1.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                                    ),
                                ) {
                                    Text(
                                        text = respuestas[i].answerText,
                                        color = if (settingsViewModel.darkMode) Color.Black else Color.White
                                    )
                                }
                            }
                            LinearProgressIndicator(
                                progress = gameViewModel.progress,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f),
                    contentAlignment = Alignment.Center
                ) {
                    GifImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(1f, 1f)
                            .aspectRatio(1f),
                        imageID = currentQuestion.questionImage
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
                                respuestas = currentQuestion.answers
                                gameViewModel.checkAnswer(
                                    respuestas[0],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                            ),
                        ) {
                            Text(
                                text = respuestas[0].answerText,
                                color = if (settingsViewModel.darkMode) Color.Black else Color.White
                            )
                        }
                        Button(
                            onClick = {
                                respuestas = currentQuestion.answers
                                gameViewModel.checkAnswer(
                                    respuestas[1],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                            ),
                        ) {
                            Text(
                                text = respuestas[1].answerText,
                                color = if (settingsViewModel.darkMode) Color.Black else Color.White
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
                                respuestas = currentQuestion.answers
                                gameViewModel.checkAnswer(
                                    respuestas[2],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                            ),
                        ) {
                            Text(
                                text = respuestas[2].answerText,
                                color = if (settingsViewModel.darkMode) Color.Black else Color.White
                            )
                        }
                        Button(
                            onClick = {
                                respuestas = currentQuestion.answers
                                gameViewModel.checkAnswer(
                                    respuestas[3],
                                    settingsViewModel
                                )
                            },
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (settingsViewModel.darkMode) goldenColor else Color.Magenta
                            ),
                        ) {
                            Text(
                                text = respuestas[3].answerText,
                                color = if (settingsViewModel.darkMode) Color.Black else Color.White
                            )
                        }
                    }
                    LinearProgressIndicator(
                        progress = gameViewModel.progress,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
    imageID: Int
){
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder(context))
            } else {
                add(GifDecoder())
            }
        }
        .build()
    Image(
        painter = rememberImagePainter(
            imageLoader = imageLoader,
            data = imageID,
            builder = {
                size(OriginalSize)
            }
        ),
        contentDescription = null,
        modifier = modifier
    )
}