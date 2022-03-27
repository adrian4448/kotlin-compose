package com.example.jogo_adivinha

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jogo_adivinha.ui.theme.Jogo_AdivinhaTheme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jogo_AdivinhaTheme {
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
    var userNumber by remember {
        mutableStateOf("0")
    }

    var randomNumber by remember {
        mutableStateOf(rand(1, 100))
    }


    var userGameStatus by remember {
        mutableStateOf("")
    }

    if(userGameStatus.equals("")) {
        AdivinhaGame(userNumber,
            randomNumber,
            onUserTentative = {
                userGameStatus = it
            },
            onNumberChange = {
                userNumber = it
            })
    } else {
        StatusModal(userGameStatus,
            backToGame = {
                userGameStatus = it
            },
            resetNumber = {
                randomNumber = it.toInt()
            })
    }
}

@Composable
fun AdivinhaGame(number: String,
                 numRandom: Number,
                 onUserTentative: (String) -> Unit,
                 onNumberChange: (String) -> Unit) {

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current

        Button(onClick = {
            if (number.toInt() === numRandom.toInt()) {
                onUserTentative("ACERTOU")
            } else if (number.toInt() > numRandom.toInt()) {
                onUserTentative("MAIOR")
            } else {
                onUserTentative("MENOR")
            }
        }) {
            Text(text = "Colocar Número")
        }

        OutlinedTextField(
            value = number,
            onValueChange = { onNumberChange(it) }
        )
    }
}

@Composable
fun StatusModal(status: String,
                backToGame: (String) -> Unit,
                resetNumber: (Number) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = returnTextByStatus(status))
        Button(onClick = {
            if(status.equals("ACERTOU")) {
                resetNumber(rand(0, 100))
            }
            backToGame("")
        }) {
            Text(text = "Voltar")
        }
    }
}

fun returnTextByStatus(status: String): String {
    if(status.equals("ACERTOU")) {
        return "Parabéns Fera vc acertou"
    }else if(status.equals("MAIOR")) {
        return "O Número que você disse e maior"
    }

    return "O Número que você disse e menor"
}

fun rand(from: Int, to: Int) : Int {
    val random = Random()
    return random.nextInt(to - from) + from // from(incluso) e to(excluso)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jogo_AdivinhaTheme {
        MyApp()
    }
}