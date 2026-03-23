package com.example.gestaodeestado.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gestaodeestado.calculos.calcularJuros
import com.example.gestaodeestado.calculos.calcularMontante

class JurosScreenViewModel: ViewModel() {
    private val _capitalState = MutableLiveData<String>()
    private val _taxaState = MutableLiveData<String>()
    private val _tempoState = MutableLiveData<String>()
    private val _jurosState = MutableLiveData<Double>()

    private val _montanteState = MutableLiveData<Double>()

    var capital: LiveData<String> = _capitalState
    var taxa : LiveData<String> = _taxaState
    var tempo: LiveData<String> = _tempoState

    var juros: LiveData<Double> = _jurosState

    var montante: LiveData<Double> = _montanteState

    fun onCapitalChanged(novoCapital: String){
        _capitalState.value = novoCapital
    }
    fun onTaxaChanged(novaTaxa: String){
        _taxaState.value  =novaTaxa
    }

    fun onTempoChanged(novoTempo: String){
        _tempoState.value = novoTempo
    }

//    fun onJurosChanged(novoJuros: Double){
//        _jurosState.value = novoJuros
//    }
//
//    fun onMontanteChanged(novoMontante: Double){
//        _montanteState.value = novoMontante
//    }

    fun calculatJurosChanged(){
        _jurosState.value = calcularJuros(
            capital = _capitalState.value!!.toDouble(),
            taxa = _taxaState.value!!.toDouble(),
            tempo = _tempoState.value!!.toDouble()
        )
    }

    fun calcularMontanteInvestimento(){
        _montanteState.value = calcularMontante(
            capital = _capitalState.value!!.toDouble(),
            juros = _jurosState.value!!
        )
    }
}