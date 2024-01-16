package com.example.trivialapp_sergiherrador.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.trivialapp_sergiherrador.R
import com.example.trivialapp_sergiherrador.ViewModel.MenuViewModel
import com.example.trivialapp_sergiherrador.ViewModel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavHostController, settingsViewModel: SettingsViewModel) {
    var selectedText by remember { mutableStateOf("Difficulty") }
    var expanded by remember { mutableStateOf(false) }
    val difficulties = listOf("Easy", "Medium", "Hard")

    Row(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Texto de dificultad
            Text(
                text = "Difficulty:",
                modifier = Modifier.fillMaxWidth()
            )

            // DropdownMenu
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .background(Color(255f / 255, 0f / 255, 238f / 255, 0.1f))
            ) {
                OutlinedTextField(
                    value = selectedText,
                    onValueChange = { selectedText = it },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .fillMaxWidth()
                        .background(Color(255f / 255, 0f / 255, 238f / 255, 0.1f))
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color(255f / 255, 0f / 255, 238f / 255, 0.1f))
                        .fillMaxWidth()
                ) {
                    difficulties.forEach { difficulty ->
                        DropdownMenuItem(
                            text = { Text(text = difficulty) },
                            onClick = {
                                expanded = false
                                selectedText = difficulty
                            }
                        )
                    }
                }
            }

            var selectedRounds by remember { mutableStateOf(5) }

            Row {
                Text(text = "Rounds: ")
                var roundsAvailable: MutableList<Int> = mutableListOf(5, 10, 15)
                Column {
                    (roundsAvailable).forEach { rounds ->
                        Row {
                            Checkbox(
                                checked = selectedRounds == rounds,
                                onCheckedChange = {
                                    selectedRounds = if (it) rounds else selectedRounds
                                },
                                modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = "$rounds",
                                modifier = Modifier.clickable {
                                    selectedRounds = rounds
                                }
                            )
                        }
                    }

                }

            }

            var sliderValue by remember { mutableStateOf(0f) }
            var finishValue by remember { mutableStateOf("") }

            Row {
                Text(text = "Temps: ")
                Column {
                    Slider(
                        value = sliderValue,
                        onValueChange = { sliderValue = it },
                        onValueChangeFinished = {
                            finishValue = "%.0f".format(sliderValue)
                        },
                        valueRange = 0f..120f,
                        steps = 119
                    )

                    Text(
                        text = if (finishValue != "") {
                            "$finishValue seconds"
                        } else {
                            ""
                        }
                    )

                }
            }
            // Dark mode
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Dark mode",
                    modifier = Modifier.fillMaxHeight(0.2f)
                )
                var state by rememberSaveable { mutableStateOf(true) }
                Switch(
                    checked = state,
                    onCheckedChange = { state = !state },
                    colors = SwitchDefaults.colors(
                        uncheckedThumbColor = Color.Red,
                        checkedThumbColor = Color.Green
                    ),
                    modifier = Modifier.fillMaxHeight(0.2f)
                )
            }
            Button(onClick = {  navController.navigate("MenuScreen") },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Volver al menú")
            }
        }

    }
}

