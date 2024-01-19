package com.example.trivialapp_sergiherrador.ViewModel

import android.graphics.drawable.GradientDrawable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    var expanded by mutableStateOf(false)
        private set

    fun modifyExpanded(valor: Boolean) {
        expanded = valor
    }

    var dificultad: String by mutableStateOf("Medium")
        private set

    fun modifyDifficulty(dificultadCambiada: String) {
        dificultad = dificultadCambiada
    }

    var rondas: Int by mutableIntStateOf(5)
        private set

    fun modifyRondas(rondasSelected: Int) {
        rondas = rondasSelected
    }

    var sliderValue by mutableStateOf(0f)
        private set

    fun modifySliderValue(sliderChangedValue: Float) {
        sliderValue = sliderChangedValue
    }

    var finishSliderValue by mutableStateOf("")
        private set

    fun modifyFinishSlider(valorFinishSlider: String) {
        finishSliderValue = valorFinishSlider
    }

    var darkMode: Boolean by mutableStateOf(false)
        private set

    fun modifyEstadoSwitch(estadoActual: Boolean) {
        darkMode = estadoActual
    }

    fun getGradient(): Brush {
        var gradient = Brush.linearGradient(
            colors = listOf(
                Color.Blue,
                Color.Cyan,
                Color.White
            ),
            start = Offset(0f, 0f),
            end = Offset.Infinite
        )
        if (darkMode) {
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color.Black,
                    Color.Black,
                    Color.DarkGray
                ),
                start = Offset(0f, 0f),
                end = Offset.Infinite
            )
        }
        return gradient
    }
}
