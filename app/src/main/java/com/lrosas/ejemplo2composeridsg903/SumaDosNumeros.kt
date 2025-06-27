package com.lrosas.ejemplo2composeridsg903

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SumaDosNumeros(){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),

        ){
        TextField(
            value = num1,
            onValueChange = {num1 = it },
            label = { Text("Numero 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = num2,
            onValueChange = {num1 = it },
            label = { Text("Numero 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {

            val n1 = num1.toIntOrNull()
            val n2 = num2.toIntOrNull()
            resultado = if (n1 != null && n2 != null){
                "${n1 + n2}"
            }else{
                "ingrese valores validos"
            }
        }){
            Text("Sumar")
        }
        Text(text = resultado)


    }
}
@Composable
fun OperacionesBasicas() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var operacionSeleccionada by remember { mutableStateOf("Suma") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Column {
            listOf("Suma", "Resta", "Multiplicación", "División").forEach { operacion ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = operacionSeleccionada == operacion,
                        onClick = { operacionSeleccionada = operacion }
                    )
                    Text(text = operacion)
                }
            }
        }

        Button(onClick = {
            val n1 = num1.toIntOrNull()
            val n2 = num2.toIntOrNull()
            resultado = when (operacionSeleccionada) {
                "Suma" -> if (n1 != null && n2 != null) "${n1 + n2}" else "Ingrese valores válidos"
                "Resta" -> if (n1 != null && n2 != null) "${n1 - n2}" else "Ingrese valores válidos"
                "Multiplicación" -> if (n1 != null && n2 != null) "${n1 * n2}" else "Ingrese valores válidos"
                "División" -> if (n1 != null && n2 != null && n2 != 0) "${n1 / n2}" else "Ingrese valores válidos o evite la división por cero"
                else -> "Operación no válida"
            }
        }) {
            Text("Calcular")
        }
        Text(text = resultado)
    }
}
