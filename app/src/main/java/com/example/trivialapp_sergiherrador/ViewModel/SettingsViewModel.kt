package com.example.trivialapp_sergiherrador.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel(){
    var show: Boolean by mutableStateOf(false)
        private set

    fun modifyShow(value: Boolean){
        show = value
    }
}