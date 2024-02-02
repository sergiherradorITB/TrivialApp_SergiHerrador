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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        LaunchedEffect(gameViewModel, settingsViewModel) {
            if (!gameViewModel.gameStarted) {
                gameViewModel.startTimer(settingsViewModel)
                gameViewModel.startGame(settingsViewModel)
            }
        }
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
                    color = if (settingsViewModel.darkMode) Color.White else Color(245, 245, 220),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = currentQuestion.questionText,
                    modifier = Modifier
                        .fillMaxHeight(0.6f),
                    fontSize = 20.sp,
                    color = if (settingsViewModel.darkMode) Color.White else Color.Black,
                    textAlign = TextAlign.Center
                )

            }
            // Main Content
            if (windowSize.widthSizeClass >= WindowWidthSizeClass.Medium) {
                Row(modifier = Modifier.fillMaxSize()) {
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
                                .fillMaxHeight()
                                .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Utilizar los textos de las respuestas en los botones
                            for (i in 0 until 4) {
                                Button(
                                    onClick = {
                                        respuestas = currentQuestion.answers
                                        if (gameViewModel.buttonEnabled) {
                                            gameViewModel.checkAnswer(
                                                respuestas[i],
                                                settingsViewModel
                                            )
                                            gameViewModel.modifyShowBackground(true)
                                            gameViewModel.buttonEnabled = false
                                        }
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 1.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        if (settingsViewModel.darkMode && !gameViewModel.showBackground) goldenColor
                                        else if (!settingsViewModel.darkMode && !gameViewModel.showBackground) Color.Magenta
                                        else if (respuestas[i].isCorrect) Color.Green
                                        else Color.Red,
                                        disabledContentColor = if (respuestas[i].isCorrect) Color.Green else Color.Red
                                    )
                                ) {
                                    Text(
                                        text = respuestas[i].answerText,
                                        color = if (settingsViewModel.darkMode) Color.Black else Color.White,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            LinearProgressIndicator(
                                progress = gameViewModel.pillarProgress(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                            if (gameViewModel.pillarProgress() in 0.0..1.0) {
                                val formattedProgress = "%.0f".format(gameViewModel.pillarUpTime())
                                Text(text = "$formattedProgress / ${"%.0f".format(settingsViewModel.sliderValue)}"
                                , color = if (settingsViewModel.darkMode) goldenColor else Color.Black)
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
                        .fillMaxHeight(1f)
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Respuestas en botones
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Botones 1 y 2
                        for (i in 0 until 2) {
                            Button(
                                onClick = {
                                    respuestas = currentQuestion.answers
                                    if (gameViewModel.buttonEnabled) {
                                        gameViewModel.checkAnswer(respuestas[i], settingsViewModel)
                                        gameViewModel.modifyShowBackground(true)
                                        gameViewModel.buttonEnabled = false
                                    }
                                },
                                modifier = Modifier
                                    .weight(0.4f)
                                    .padding(end = 8.dp)
                                    .fillMaxWidth()
                                    .padding(vertical = 1.dp),
                                colors = ButtonDefaults.buttonColors(
                                    if (settingsViewModel.darkMode && !gameViewModel.showBackground) goldenColor
                                    else if (!settingsViewModel.darkMode && !gameViewModel.showBackground) Color.Magenta
                                    else if (respuestas[i].isCorrect) Color.Green
                                    else Color.Red,
                                    disabledContentColor = if (respuestas[i].isCorrect) Color.Green else Color.Red
                                ),

                            ) {
                                Text(
                                    text = respuestas[i].answerText,
                                    color = if (settingsViewModel.darkMode) Color.Black else Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }

                        }
                    }

                    // Segunda fila de botones
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Botones 3 y 4
                        for (i in 2 until 4) {
                            Button(
                                onClick = {
                                    respuestas = currentQuestion.answers
                                    if (gameViewModel.buttonEnabled) {
                                        gameViewModel.checkAnswer(respuestas[i], settingsViewModel)
                                        gameViewModel.modifyShowBackground(true)
                                        gameViewModel.buttonEnabled = false
                                    }
                                },
                                modifier = Modifier
                                    .weight(0.4f)
                                    .padding(end = 8.dp)
                                    .fillMaxWidth()
                                    .padding(vertical = 1.dp),
                                colors = ButtonDefaults.buttonColors(
                                    if (settingsViewModel.darkMode && !gameViewModel.showBackground) goldenColor
                                    else if (!settingsViewModel.darkMode && !gameViewModel.showBackground) Color.Magenta
                                    else if (respuestas[i].isCorrect) Color.Green
                                    else Color.Red,
                                    disabledContentColor = if (respuestas[i].isCorrect) Color.Green else Color.Red
                                ),

                                ) {
                                Text(
                                    text = respuestas[i].answerText,
                                    color = if (settingsViewModel.darkMode) Color.Black else Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }

                        }
                    }

                    // Indicador de progreso lineal
                    LinearProgressIndicator(
                        progress = gameViewModel.pillarProgress(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    if (gameViewModel.pillarProgress() in 0.0..1.0) {
                        val formattedProgress = "%.0f".format(gameViewModel.pillarUpTime())
                        Text(text = "$formattedProgress / ${"%.0f".format(settingsViewModel.sliderValue)}"
                            , color = if (settingsViewModel.darkMode) goldenColor else Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
    imageID: Int
) {
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