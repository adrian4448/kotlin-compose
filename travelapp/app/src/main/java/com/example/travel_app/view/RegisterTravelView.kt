package com.example.travel_app.view

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.ScreenManager
import com.example.travel_app.entity.TipoViagem
import com.example.travel_app.viewModel.TravelFactory
import com.example.travel_app.viewModel.TravelViewModel
import com.example.travel_app.viewModel.UserFactory

@Composable
fun RegisterTravelView(navController: NavController) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application
    var selectedOption = remember { mutableStateOf("") }

    val travel: TravelViewModel = viewModel(factory = TravelFactory(app))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(Modifier.padding(all= 60.dp)) {
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.destiny,
                label = {
                    Text(text = "Destino")
                },
                onValueChange = { travel.destiny =it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.budget.toString(),
                label = {
                    Text(text = "Valor da viagem")
                },
                onValueChange = { travel.budget = Integer.parseInt(it).toDouble(); })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.comingDate,
                label = {
                    Text(text = "Data de chegada")
                },
                onValueChange = { travel.comingDate = it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = travel.departureDate,
                label = {
                    Text(text = "Data de partida")
                },
                onValueChange = { travel.departureDate = it; })
            Row(Modifier.padding(start = 10.dp)) {
                Text(text = "Lazer")
                RadioButton(modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    selected = selectedOption.value == "Viagem de lazer",
                    onClick = {
                        selectedOption.value = "Viagem de lazer"
                    })
                Text(text = "Negocio")
                RadioButton(modifier = Modifier.padding(start = 10.dp),
                    selected =  selectedOption.value == "Viagem de negocio",
                    onClick = {
                        selectedOption.value = "Viagem de negocio"
                    })
            }
        }
        Row(Modifier.padding(all= 60.dp)) {
            OutlinedButton(modifier = Modifier.padding(all= 5.dp),onClick =  {
                navController.navigate(ScreenManager.Travel.route) { }
            }) {
                Text(text = "Voltar")
            }

            OutlinedButton(modifier = Modifier.padding(all= 5.dp), onClick =  {
                navController.navigate(ScreenManager.Travel.route) {
                    if(selectedOption.value == "Viagem de lazer") {
                        travel.type = TipoViagem.LAZER
                    }else {
                        travel.type = TipoViagem.NEGOCIO
                    }

                    travel.register()
                }
            }) {
                Text(text = "Cadastrar")
            }
        }
    }
}