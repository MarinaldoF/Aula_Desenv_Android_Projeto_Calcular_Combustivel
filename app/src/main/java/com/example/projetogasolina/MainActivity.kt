package com.example.projetogasolina

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcular_btn.setOnClickListener {

            // verificando se altura e peso não estão vazio
            if (eAltura.text.isNotEmpty() && ePeso.text.isNotEmpty()) {
                val altura = (eAltura.text.toString()).toInt()
                val peso = (ePeso.text.toString()).toInt()

                // calcular o imc
                val IMC = calculateBMI(altura, peso)

                imc.text = IMC.toString()
                imc.visibility = View.VISIBLE

                // condição para calculo do imc, depenendo da altura e peso vai ser exibido uma mesangem de acordo
                if (IMC < 18.5) {
                    status.text = "Abaixo do peso"
                } else if (IMC >= 18.5 && IMC < 24.9) {
                    status.text = "Está Saudável"
                } else if (IMC >= 24.9 && IMC < 30) {
                    status.text = "Acima do Peso"
                } else if (IMC >= 30) {
                    status.text = "Sofrendo de Obesidade"
                }

                bmi_tv.visibility = View.VISIBLE
                status.visibility = View.VISIBLE

                ReCalcular.visibility = View.VISIBLE
                calcular_btn.visibility = View.GONE

            }

            //quando altura e peso for nulo vai ser exibido essa frase
            else {
                Toast.makeText(this, "Insira a altura e o peso válidos", Toast.LENGTH_SHORT).show()
            }
        }

        ReCalcular.setOnClickListener {
            ResetEverything()
        }

    }

    // Função para redefinir todos os campos Text e EditText.
    private fun ResetEverything() {

        calcular_btn.visibility = View.VISIBLE
        ReCalcular.visibility = View.GONE

        eAltura.text.clear()
        ePeso.text.clear()
        status.text = " "
        imc.text = " "
        bmi_tv.visibility = View.GONE
    }

    // Função para cálculo do IMC
    private fun calculateBMI(altura: Int, peso: Int): Float {

        val Altura_metro = altura.toFloat() / 100
        val IMC = peso.toFloat() / (Altura_metro * Altura_metro)

        return IMC
    }
}
