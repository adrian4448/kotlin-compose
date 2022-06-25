package com.example.travel_app.view

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travel_app.R
import com.example.travel_app.ScreenManager
import com.example.travel_app.components.PasswordField
import com.example.travel_app.viewModel.UserFactory
import com.example.travel_app.viewModel.UserViewModel

@Composable
fun LoginView(navController: NavController) {
    val ctx = LocalContext.current
    val app = ctx.applicationContext as Application

    val user: UserViewModel = viewModel(factory = UserFactory(app))

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.aviao),
            contentDescription = "Login Image",
        )

        OutlinedTextField(modifier = Modifier.padding(20.dp), value = user.userName, onValueChange = { user.userName =it; })
        PasswordField(value = user.password, modifier = Modifier.padding(20.dp), onChange = { user.password = it});

        OutlinedButton(modifier = Modifier.padding(all= 10.dp), onClick =  {
            user.login(onSuccess = {
                Toast.makeText(context, "Login ok", Toast.LENGTH_SHORT).show();
                navController.navigate(ScreenManager.Home.route) { }
            }, onFail = {
                Toast.makeText(context, "Login inválido", Toast.LENGTH_LONG).show();
            })
        }) {
            Text(text = "Login")
        }

        Row(Modifier.padding(all= 60.dp)) {
            OutlinedButton(modifier = Modifier.padding(all= 5.dp),onClick =  {
                navController.navigate(ScreenManager.Register.route) {

                }

            }) {
                Text(text = "Registrar")
            }

            OutlinedButton(modifier = Modifier.padding(all= 5.dp), onClick =  {
                navController.navigate(ScreenManager.Home.route) {

                }
            }) {
                Text(text = "Recuperar senha")
            }
        }
    }
}