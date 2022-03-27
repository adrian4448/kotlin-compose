package com.example.tip_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tip_calculator.components.LabelText
import com.example.tip_calculator.components.SliderText
import com.example.tip_calculator.ui.theme.Tip_CalculatorTheme
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tip_CalculatorTheme {
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
    val formatter = DecimalFormat("#.###")
    formatter.roundingMode = RoundingMode.CEILING

    var amountValue by remember {
        mutableStateOf("0")
    }

    var amountPorcentage by remember {
        mutableStateOf("0")
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(10.dp)
    ) {
        val amount = if (!amountValue.equals("")) amountValue.toFloat() else 0
        val realAmountPorcentage = if (!amountPorcentage.equals("")) (amountPorcentage.toFloat() / 100) else 0

        LabelText(label = "Amount",
            textValue = amountValue,
            onValueChange = {
                amountValue = it
            })

        Row {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(10.dp)
            ) {
                SliderText(label = "Custom %",
                    value = amountPorcentage.toFloat(),
                    onValueChange = {
                        amountPorcentage = it
                    })
            }
        }

        Row {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(0.dp, 85.dp, 0.dp, 0.dp)
            ) {
                Text(text = "Tip",
                    modifier = Modifier.padding(20.dp))
                Text(text = "Total",
                    modifier = Modifier.padding(20.dp))
            }
            Column(modifier = Modifier.padding(20.dp)) {
                val tipAmount =  amount.toFloat() * 0.15

                Text(text = "15%",
                    modifier = Modifier.padding(20.dp))

                Text(text = "$ ${tipAmount}",
                    modifier = Modifier.padding(20.dp))

                Text(text = ("$ ${formatter.format(tipAmount + amount.toFloat())}"),
                    modifier = Modifier.padding(20.dp))
            }

            Column(modifier = Modifier.padding(20.dp)) {
                val tipAmount =  amount.toFloat() * realAmountPorcentage.toFloat()

                Text(text = "${amountPorcentage}%",
                    modifier = Modifier.padding(20.dp))

                Text(text = "$ ${tipAmount}",
                    modifier = Modifier.padding(20.dp))

                Text(text = "$ ${formatter.format(tipAmount + amount.toFloat())}",
                    modifier = Modifier.padding(20.dp))
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tip_CalculatorTheme {
        MyApp()
    }
}