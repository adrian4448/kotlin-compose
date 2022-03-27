package com.example.fahrenheit_celsios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fahrenheit_celsios.ui.theme.Fahrenheit_CelsiosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fahrenheit_CelsiosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    var userTemperature by remember {
        mutableStateOf("0")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Converta sua temperatura"
        )

        convertTemperature(userTemperature,
                            onTemperatureChange = {
                                userTemperature = it
                            })
    }

}

@Composable
fun convertTemperature(userTemperature: String,
                        onTemperatureChange: (String) -> Unit) {
    OutlinedTextField(
        value = userTemperature,
        onValueChange = {  onTemperatureChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = {
            val fahrenheitTemperature = (userTemperature.toFloat() * 1.8) + 32
            onTemperatureChange(fahrenheitTemperature.toString())
        }) {
            Text(text = "Converter para Fahrenheit")
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = {
            val fahrenheitTemperature = (userTemperature.toFloat() - 32) / 1.8
            onTemperatureChange(fahrenheitTemperature.toString())
        }) {
            Text(text = "Converter para Celsios")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Fahrenheit_CelsiosTheme {
        MyApp()
    }
}