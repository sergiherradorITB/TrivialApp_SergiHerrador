package com.example.trivialapp_sergiherrador

sealed class Routes(val route: String) {
    object MenuScreen:Routes("MenuScreen")
    object SettingsScreen:Routes("SettingsScreen")

}
