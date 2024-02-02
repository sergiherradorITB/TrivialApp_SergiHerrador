package com.example.trivialapp_sergiherrador.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {

    var nota:Int by mutableIntStateOf(0)
        private set
    fun pillarNota(gameViewModel: GameViewModel, settingsViewModel: SettingsViewModel) {
        // Check if rondas is not zero to avoid division by zero
        nota = if (settingsViewModel.rondas != 0) {
            (gameViewModel.aciertos * 10) / settingsViewModel.rondas
        } else {
            0
        }
    }

    fun modificarNota(notaNueva:Int){
        nota = notaNueva
    }

    fun textoNota():String{
        return when (nota){
            in 0..4 -> "Deficient"
            in 5..7 -> "Molt bé"
            in 8..9 -> "Excelent"
            10 -> "TODO BIENN!!"
            else -> {"No sé que tienes"}
        }
    }

}
