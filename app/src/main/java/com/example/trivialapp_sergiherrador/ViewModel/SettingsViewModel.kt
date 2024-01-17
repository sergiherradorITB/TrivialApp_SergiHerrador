package com.example.trivialapp_sergiherrador.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel(){

    var expanded by mutableStateOf(false)
        private set

    fun modifyExpanded(valor:Boolean){
        expanded = valor
    }

    var dificultad:String by mutableStateOf("Medium")
        private set

    fun modifyDifficulty(dificultadCambiada:String){
        dificultad = dificultadCambiada
    }

    var rondas:Int by mutableIntStateOf(5)
        private set

    fun modifyRondas(rondasSelected:Int){
        rondas = rondasSelected
    }

    var sliderValue by mutableStateOf(0f)
        private set

    fun modifySliderValue(sliderChangedValue:Float){
        sliderValue = sliderChangedValue
    }

    var finishSliderValue by mutableStateOf("")
        private set

    fun modifyFinishSlider(valorFinishSlider:String){
        finishSliderValue = valorFinishSlider
    }

    var estadoSwitch:Boolean by mutableStateOf(true)
        private set

    fun modifyEstadoSwitch(estadoActual:Boolean){
        estadoSwitch = estadoActual
    }
}