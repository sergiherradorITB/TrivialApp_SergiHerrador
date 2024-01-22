package com.example.trivialapp_sergiherrador.ViewModel

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_sergiherrador.Model.Question
import com.example.trivialapp_sergiherrador.Model.easyQuestions
import com.example.trivialapp_sergiherrador.Model.hardQuestions
import com.example.trivialapp_sergiherrador.Model.mediumQuestions
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// ViewModel --> Aquí se ponen variables y funciones para cambiarlas

class GameViewModel : ViewModel() {
    var actualRound: Int by mutableStateOf(0)
        private set
    var allQuestions by mutableStateOf(easyQuestions + mediumQuestions + hardQuestions)
        private set

    var currentQuestionIndex: Int by mutableStateOf(0)
        private set

    var gameFinished: Boolean by mutableStateOf(false)
        private set

    var isCorrectAnswer: Boolean by mutableStateOf(false)
        private set

    var fallos: Int by mutableIntStateOf(0)
        private set

    var aciertos: Int by mutableIntStateOf(0)
        private set

    var currentQuestion = mutableStateOf(getCurrentQuestion(settingsViewModel = SettingsViewModel()))

    // Método para obtener la pregunta actual
    fun getCurrentQuestion(settingsViewModel: SettingsViewModel): Question {
        return when (settingsViewModel.dificultad) {
            "Easy" -> {
                easyQuestions.random()
            }

            "Medium" -> {
                mediumQuestions.random()
            }

            "Hard" -> {
                hardQuestions.random()
            }

            else -> {
                allQuestions.random()
            }
        }
    }

    var progress by mutableStateOf(0.0f)

    init {
        viewModelScope.launch {
            while (progress < 1.0f) {
                delay(1000)
                progress += 0.1f
            }
            moveToNextQuestion(settingsViewModel = SettingsViewModel())
        }
    }


    fun moveToNextQuestion(settingsViewModel: SettingsViewModel) {
        actualRound++
        isCorrectAnswer = false
        currentQuestionIndex++

        if (actualRound >= settingsViewModel.rondas) {
            // El juego ha terminado
            gameFinished = true
        }
    }

    fun checkAnswer(answer: Question.Answer, settingsViewModel: SettingsViewModel) {
        isCorrectAnswer = answer.isCorrect
        if (isCorrectAnswer) {
            aciertos++
        } else {
            fallos++
        }
        moveToNextQuestion(settingsViewModel)
    }

    fun resetGame() {
        actualRound = 0
        isCorrectAnswer = false
        gameFinished = false
        fallos = 0
        aciertos = 0
        currentQuestionIndex = 0
        progress = 0f
    }
}