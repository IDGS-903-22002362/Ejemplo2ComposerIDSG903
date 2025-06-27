package com.lrosas.ejemplo2composeridsg903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.lrosas.ejemplo2composeridsg903.ui.theme.Ejemplo2ComposerIDSG903Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            OperacionesBasicas()//            val navController = rememberNavController()
//            NavHost(navController = navController, startDestination = "inicio"){
//                composable("inicio"){PantallaInicio(navController)}
//                composable ("detalle/{nombre}"){
//                        backStackEntry ->
//                    val nombre = backStackEntry.arguments?.getString("nombre") ?: "Invitado"
//                    PantallaDetalle(navController, nombre)
//                }
//            }
        }
    }
}

@Composable
fun PantallaInicio(navController: NavHostController){
    var nombre by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Pantalla de Inicio")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nombre,
            onValueChange = {nombre = it },
            label = { Text ("Ingrese su nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button( onClick = {
            val nombre = nombre.ifBlank {"Cardiel"}
            navController.navigate("detalle/{nombre}")
        }) {
            Text("Ir a Detalle con nombre ")
        }
    }
}

@Composable
fun PantallaDetalle(navController: NavHostController, nombre: String){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Hola, $nombre")
        Button(onClick = {navController.navigate("inicio")}) {
            Text("Volver")
        }
    }
}


