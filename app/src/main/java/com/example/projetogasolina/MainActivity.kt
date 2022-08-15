package com.example.projetogasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //função que calcula o valor dos combustiveis
    fun calcularPreco(view: View) {
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validaCampos(precoAlcool, precoGasolina)
        if (validaCampos) {
            calcularMelhorPreco(precoAlcool, precoGasolina)

        } else {
            textResultado.text = "Prencha os preços primeiros"
        }


    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
        //passar os valores para double
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        //divide os valores de gasolina e alcool
        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7){
            textResultado.text = "Melhor ultilizar Gasolina"

        }else{
            textResultado.text = "Melhor ultilizar Alcool"
        }


    }


    fun validaCampos(precoAlcool: String, precoGasolina: String) : Boolean {
        var camposValidados: Boolean = true
        //verifica se os campos não estão nulo
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados

    }
}
