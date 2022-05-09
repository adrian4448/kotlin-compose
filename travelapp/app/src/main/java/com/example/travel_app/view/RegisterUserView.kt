package com.example.travel_app.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.ScreenManager
import com.example.travel_app.components.PasswordField
import com.example.travel_app.viewModel.UserViewModel

@Composable
fun RegisterUserView(navController: NavController) {
    val user: UserViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(Modifier.padding(all= 60.dp)) {
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.name,
                label = {
                    Text(text = "Nome completo")
                },
                onValueChange = { user.name =it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.userName,
                label = {
                    Text(text = "Usuario")
                },
                onValueChange = { user.userName =it; })
            PasswordField(value = user.password,
                onChange = { user.password = it},
                modifier = Modifier.padding(10.dp));
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.birthday,
                label = {
                    Text(text = "Data de aniversario")
                },
                onValueChange = { user.userName =it; })
            OutlinedTextField(modifier = Modifier.padding(10.dp),
                value = user.email,
                label = {
                    Text(text = "Email")
                },
                onValueChange = { user.userName =it; })
        }
        Row(Modifier.padding(all= 60.dp)) {
            OutlinedButton(modifier = Modifier.padding(all= 5.dp),onClick =  {
                navController.navigate(ScreenManager.Login.route) {

                }
            }) {
                Text(text = "Voltar")
            }

            OutlinedButton(modifier = Modifier.padding(all= 5.dp), onClick =  {
                navController.navigate(ScreenManager.Home.route) {

                }
            }) {
                Text(text = "Cadastrar")
            }
        }
    }
}