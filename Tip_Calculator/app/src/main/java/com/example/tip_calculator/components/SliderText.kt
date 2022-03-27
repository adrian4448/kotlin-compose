package com.example.tip_calculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SliderText(label: String,
              value: Float,
              onValueChange: (String) -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = label)
        Column(Modifier.padding(15.dp)) {
            Slider(
                value = value,
                onValueChange = { onValueChange(it.toString()) },
                valueRange = 0f..30f,
                steps = 5
            )
        }

    }




}