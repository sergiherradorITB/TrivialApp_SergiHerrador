package com.example.trivialapp_sergiherrador.ViewModel

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_sergiherrador.Model.Question
import com.example.trivialapp_sergiherrador.Model.easyQuestions
import com.example.trivialapp_sergiherrador.Model.hardQuestions
import com.example.trivialapp_sergiherrador.Model.mediumQuestions
import androidx.compose.ui.platform.LocalContext


// ViewModel --> Aquí se ponen variables y funciones para cambiarlas

class GameViewModel : ViewModel() {
    var actualRound: Int by mutableStateOf(1)
        private set

    var currentQuestionIndex: Int by mutableStateOf(0)
        private set

    var gameFinished: Boolean by mutableStateOf(false)
        private set

    var isCorrectAnswer: Boolean by mutableStateOf(false)
        private set

    // Lista completa de preguntas
    private val allQuestions = easyQuestions + mediumQuestions + hardQuestions

    var fallos:Int by mutableIntStateOf(0)
        private set

    var aciertos:Int by mutableIntStateOf(0)
        private set

    // Método para obtener la pregunta actual
    fun getCurrentQuestion(): Question {
        // Asegurarse de que el índice esté dentro de los límites de la lista
        return if (currentQuestionIndex >= 0 && currentQuestionIndex < allQuestions.size) {
            allQuestions[currentQuestionIndex]
        } else {
            // En caso de que el índice sea incorrecto, devolver una pregunta vacía o manejar el error según tu lógica
            Question("", "", 0, Question.Difficulty.EASY, emptyList())
        }
    }

    fun moveToNextQuestion() {
        actualRound++
        isCorrectAnswer = false
        currentQuestionIndex++

        if (actualRound >= allQuestions.size) {
            // El juego ha terminado
            gameFinished = true
        }
    }

    fun checkAnswer(answer: Question.Answer) {
        isCorrectAnswer = answer.isCorrect
        if (isCorrectAnswer) {
            aciertos++
        } else {
            fallos++
        }
        moveToNextQuestion()
    }

    fun resetGame() {
        actualRound = 1
        isCorrectAnswer = false
        gameFinished = false
        fallos = 0
        aciertos = 0
        currentQuestionIndex = 0
    }
}
