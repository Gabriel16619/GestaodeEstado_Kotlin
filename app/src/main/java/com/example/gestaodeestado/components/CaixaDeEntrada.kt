package com.example.gestaodeestado.components


import android.R.attr.label
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    corTema: Color,
    value: String,
    atualizarValor: (String) -> Unit
) {
    OutlinedTextField(
     label = {
         Text(text = label)
     },
        placeholder = {
            Text(text = placeholder)
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = corTema,
            unfocusedTextColor = corTema
        ),
        shape = CircleShape,
        modifier = modifier,
        value = value,
       onValueChange = {
           atualizarValor(it)
       }
    )
}