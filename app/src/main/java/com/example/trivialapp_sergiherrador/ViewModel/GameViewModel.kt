package com.example.trivialapp_sergiherrador.ViewModel

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_sergiherrador.Model.Question
import com.example.trivialapp_sergiherrador.Model.easyQuestions
import com.example.trivialapp_sergiherrador.Model.hardQuestions
import com.example.trivialapp_sergiherrador.Model.mediumQuestions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


// ViewModel --> Aquí se ponen variables y funciones para cambiarlas

class GameViewModel : ViewModel() {
    var showBackground:Boolean by mutableStateOf(false)
        private set
    fun modifyShowBackground(valor:Boolean){
        showBackground = valor
    }

    var actualRound: Int by mutableIntStateOf(1)
        private set
    var allQuestions by mutableStateOf(easyQuestions + mediumQuestions + hardQuestions)
        private set

    var currentQuestionIndex: Int by mutableIntStateOf(0)
        private set

    var gameFinished: Boolean by mutableStateOf(false)
        private set

    var isCorrectAnswer: Boolean by mutableStateOf(false)
        private set

    var fallos: Int by mutableIntStateOf(0)
        private set

    var aciertos: Int by mutableIntStateOf(0)
        private set

    var currentQuestion = getCurrentQuestion(settingsViewModel = SettingsViewModel())

    var gameStarted by mutableStateOf(false)
        private set


    @SuppressLint("NewApi")
    fun getCurrentQuestion(settingsViewModel: SettingsViewModel): Question {
        var respuesta: Question
        when (settingsViewModel.dificultad) {
            "Fácil" -> {
                val allEasyQuestionsAnswered = easyQuestions.all { it.respondida }

                if (allEasyQuestionsAnswered) {
                    easyQuestions.forEach { it.respondida = false }
                }

                respuesta = easyQuestions.random()

                if (respuesta.respondida) {
                    respuesta = getCurrentQuestion(settingsViewModel)
                }
            }

            "Media" -> {
                val allEasyQuestionsAnswered = mediumQuestions.all { it.respondida }

                if (allEasyQuestionsAnswered) {
                    mediumQuestions.forEach { it.respondida = false }
                }

                respuesta = mediumQuestions.random()

                if (respuesta.respondida) {
                    respuesta = getCurrentQuestion(settingsViewModel)
                }
            }

            "Díficil" -> {
                val allEasyQuestionsAnswered = hardQuestions.all { it.respondida }

                if (allEasyQuestionsAnswered) {
                    hardQuestions.forEach { it.respondida = false }
                }

                respuesta = hardQuestions.random()

                if (respuesta.respondida) {
                    respuesta = getCurrentQuestion(settingsViewModel)
                }
            }
            else -> {
                respuesta = allQuestions.random()
            }
        }
        respuesta.respondida = true
        return respuesta
    }

    // Método para iniciar el juego
    fun startGame(settingsViewModel: SettingsViewModel) {
        // Si el juego ya se inició, no hagas nada
        if (gameStarted) {
            return
        }

        // Reinicia el juego
        resetGame()

        // Obtén la primera pregunta basada en la dificultad actual
        currentQuestion = getCurrentQuestion(settingsViewModel)

        // Marca el juego como iniciado
        gameStarted = true
    }

    private var progress by mutableFloatStateOf(0.0f)
    fun pillarProgress():Float{
        return progress
    }

    private var upTime by mutableFloatStateOf(-1.0f)
    fun pillarUpTime():Float{
        return upTime
    }

    // Dentro de la clase GameViewModel
    private var timer: CountDownTimer? = null

    fun startTimer(settingsViewModel: SettingsViewModel) {
        // Obtén la duración del temporizador en segundos desde el modelo de vista de configuración
        val timerDuration = settingsViewModel.getSliderSeconds() * 1000L // Convierte segundos a milisegundos

        // Crea un objeto CountDownTimer con la duración y el intervalo especificados
        timer = object : CountDownTimer(timerDuration, TIMER_INTERVAL) {
            /** Se llama en cada intervalo del temporizador.
             * @param millisUntilFinished Tiempo restante en milisegundos.
             */
            override fun onTick(millisUntilFinished: Long) {
                // Calcula el progreso en función del tiempo restante
                progress = 1.0f - (millisUntilFinished.toFloat() / timerDuration.toFloat())
                upTime++ // por cada tick suma 1 al contador de cuanto llevamos
            }

             // Se llama cuando el temporizador ha finalizado.
            override fun onFinish() {
                // Incrementa el contador de fallos y avanza a la siguiente pregunta
                fallos++
                moveToNextQuestionTime(settingsViewModel)
            }
        }

        // Inicia el temporizador
        timer?.start()
    }


    fun cancelTimer() {
        timer?.cancel()
    }

    companion object {
        private const val TIMER_INTERVAL = 1000L  // Intervalo de actualización en milisegundos (1 segundo)
    }

    // Dentro de la clase GameViewModel
    var buttonEnabled by mutableStateOf(true)

    fun moveToNextQuestion(settingsViewModel: SettingsViewModel) {
        cancelTimer()
        GlobalScope.launch {
            delay(2000) // Ajusta el tiempo de espera según tus necesidades
            withContext(Dispatchers.Main) {
                buttonEnabled = true // Habilita los botones antes de cargar la nueva pregunta
                actualRound++
                isCorrectAnswer = false
                currentQuestionIndex++

                if (actualRound > settingsViewModel.rondas) {
                    // El juego ha terminado
                    gameFinished = true
                }

                progress = 0.0f
                upTime = -1.0f

                currentQuestion = getCurrentQuestion(settingsViewModel)

                startTimer(settingsViewModel)
                modifyShowBackground(false)
            }
        }
    }

    fun moveToNextQuestionTime(settingsViewModel: SettingsViewModel) {
        cancelTimer()
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                buttonEnabled = true // Habilita los botones antes de cargar la nueva pregunta
                actualRound++
                isCorrectAnswer = false
                currentQuestionIndex++

                if (actualRound > settingsViewModel.rondas) {
                    // El juego ha terminado
                    gameFinished = true
                }

                progress = 0.0f
                upTime = -1.0f

                // Utiliza la lógica existente para obtener la siguiente pregunta según la dificultad actual
                currentQuestion = getCurrentQuestion(settingsViewModel)

                startTimer(settingsViewModel)
                modifyShowBackground(false)
            }
        }
    }

    fun checkAnswer(answer: Question.Answer, settingsViewModel: SettingsViewModel):Boolean {
        isCorrectAnswer = answer.isCorrect
        if (isCorrectAnswer) {
            aciertos++
        } else {
            fallos++
        }
        moveToNextQuestion(settingsViewModel)
        return isCorrectAnswer
    }

    fun resetGame() {
        actualRound = 1
        isCorrectAnswer = false
        gameFinished = false
        fallos = 0
        aciertos = 0
        currentQuestionIndex = 0
        progress = 0f
        gameStarted = false
        allQuestions.forEach { it.respondida = false }
        upTime = -1.0f
    }
}