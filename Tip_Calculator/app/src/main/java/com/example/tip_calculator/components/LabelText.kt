package com.example.tip_calculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun LabelText(label: String,
              textValue: String,
              onValueChange: (String) -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = label)
        Column(Modifier.padding(15.dp)) {
            OutlinedTextField(value = textValue,
                onValueChange = onValueChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        }

    }




}