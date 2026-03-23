package com.example.gestaodeestado.juros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gestaodeestado.calculos.calcularJuros
import com.example.gestaodeestado.calculos.calcularMontante
import com.example.gestaodeestado.components.CaixaDeEntrada
import com.example.gestaodeestado.components.CardResultado

@Composable
fun JurosScreen(modifier: Modifier = Modifier, jurosScreenViewModel: JurosScreenViewModel){

    var corTema = Color(136, 38, 199, 255)

    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")

    val taxa by jurosScreenViewModel.taxa.observeAsState(initial = "")

    val tempo by jurosScreenViewModel.tempo.observeAsState(initial = "")

    val juros by jurosScreenViewModel.juros.observeAsState(initial = 0.0)

    val montante by jurosScreenViewModel.montante.observeAsState(initial = 0.0)


    Column (
        modifier = modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color(136, 38, 199, 255) )
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Calculadora Juros Simples",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-30).dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF9F6F6)
                    ),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Dados do investimento",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        1000
                        CaixaDeEntrada(
                            label = "Valor investido",
                            placeholder = "Quanto deseja investir ",
                            keyboardType = KeyboardType.Decimal,
                            modifier = Modifier.fillMaxWidth(),
                            value = capital,
                            corTema = corTema,
                            atualizarValor = {
                                jurosScreenViewModel.onCapitalChanged(it)
                            }
                        )

                        CaixaDeEntrada(
                            label = "taxa de juros",
                            placeholder = "Taxa de juros mensal ",
                            keyboardType = KeyboardType.Decimal,
                            modifier = Modifier.fillMaxWidth(),
                            value = taxa,
                            corTema = corTema,
                            atualizarValor = {
                                jurosScreenViewModel.onTaxaChanged(it)
                            }
                        )

                        CaixaDeEntrada(
                            label = "Tempo",
                            placeholder = "Período em meses",
                            keyboardType = KeyboardType.Decimal,
                            modifier = Modifier.fillMaxWidth(),
                            value = tempo,
                            corTema = corTema,
                            atualizarValor = {
                              jurosScreenViewModel.onTempoChanged(it)
                            }
                        )

                        Button(
                            onClick = {
                                juros = calcularJuros(
                                    capital = capital.toDouble(),
                                    taxa = taxa.toDouble(),
                                    tempo = tempo.toDouble()
                                )

                                montante = calcularMontante(
                                    capital = capital.toDouble(),
                                    juros = juros
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(
                                text = "CALCULAR",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                CardResultado(juros = juros, montante = montante)

            }
        }
    }
}
