package com.example.gestaodeestado.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gestaodeestado.calculos.calcularJuros
import com.example.gestaodeestado.calculos.calcularMontante

@Composable
fun CardResultado(
    juros: Double,
    montante: Double
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF329F6B)
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Resultado",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 28.sp,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Juros",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "$juros",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp
                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Montante",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "$montante",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}