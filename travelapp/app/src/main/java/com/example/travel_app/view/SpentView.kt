package com.example.travel_app.view

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DisabledByDefault
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.ScreenManager
import com.example.travel_app.components.BottomMenu
import com.example.travel_app.entity.Spent
import com.example.travel_app.viewModel.SpentFactory
import com.example.travel_app.viewModel.SpentViewModel
import java.text.DecimalFormat

@Composable
fun SpentView(navController: NavController, id: Int?) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application
    val spentViewModel: SpentViewModel = viewModel(factory = SpentFactory(app))
    var spents: List<Spent> = ArrayList();

    if (id != null) {
        spentViewModel.findAllSpents(id, onSuccess = {
            spents = it
        })
    }

    Scaffold(
        topBar = {
            LazyColumn(){
                items(items = spents) {
                        p -> SpentCard(p, navController)
                }
            }
        },
        bottomBar = {
            BottomMenu(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(ScreenManager.RegisterSpent.route + "/" + id) {

                }
            }) {
                /* FAB content */
            }
        }
    ) { }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpentCard(spent: Spent, navController: NavController) {
    val df = DecimalFormat("0.00")
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application
    val spentViewModel: SpentViewModel = viewModel(factory = SpentFactory(app))

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 8.dp),
        onClick = {
            navController.navigate(ScreenManager.RegisterTravel.route) {

            }
        }
    ) {
        Row() {
            Column(modifier = Modifier
                .padding(16.dp)
                .weight(1f)
            ) {
                Text(text = "Data: ${spent.date}")
                Text(text = "Descrição: ${spent.description}")
            }
            Column(modifier = Modifier
                .padding(16.dp)
                .weight(1f)
            ) {
                Text(text = "Valor: R$ ${df.format(spent.value)}")
                Text(text = "Local: ${spent.local}")
            }
            Button(onClick = {
                spentViewModel.delete(spent)
                navController.navigate(ScreenManager.Spent.route + "/" + spent.id) {

                }
            }) {
                Icon(Icons.Rounded.DisabledByDefault, contentDescription = "Localized description")
            }

        }
    }
}