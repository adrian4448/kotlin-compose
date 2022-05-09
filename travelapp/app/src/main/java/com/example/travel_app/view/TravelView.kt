package com.example.travel_app.view

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.viewModel.TravelViewModel
import com.example.travel_app.viewModel.enum.TipoViagemEnum
import java.text.DecimalFormat

@Composable
fun TravelView(navController: NavController) {

    val travel1: TravelViewModel = viewModel()
    travel1.id = 1
    travel1.budget = 1000.00
    travel1.destiny = "Cachoeirinha"
    travel1.comingDate = "01/01/2021"
    travel1.departureDate = "02/01/2021"
    travel1.type = TipoViagemEnum.LAZER

    val travel2: TravelViewModel = viewModel()
    travel2.id = 1
    travel2.budget = 1000.00
    travel2.destiny = "Cachoeirinha"
    travel2.comingDate = "01/01/2021"
    travel2.departureDate = "02/01/2021"
    travel2.type = TipoViagemEnum.LAZER

    val travels = listOf(
        travel1,
        travel2
    )

    LazyColumn(){
        items(items = travels) {
                p -> TravelCard(p)
        }
    }
}

@Composable
fun TravelCard(travel: TravelViewModel) {
    val df = DecimalFormat("0.00")
    val context = LocalContext.current
        Card(
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 8.dp)
        ) {
            Row() {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                ) {
                    Text(text = "Viagem para ${travel.destiny}")
                }
                Column(modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                ) {
                    Text(text = "Chegada: ${travel.comingDate}")
                    Text(text = "Saida: ${travel.departureDate}")
                }
                Text(
                    text = "R$ ${df.format(travel.budget)}", modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(16.dp)
                )
            }
        }
}