package br.unisanta.lei_ohm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextTensao = findViewById<EditText>(R.id.edtTextV)
        val editTextResistencia = findViewById<EditText>(R.id.edtTextR)
        val editTextCorrente = findViewById<EditText>(R.id.edtTextI)
        val textViewResultado = findViewById<TextView>(R.id.txvResult)
        val botaoCalcular = findViewById<Button>(R.id.btnCalcular)

        botaoCalcular.setOnClickListener {
            val stringTensao = editTextTensao.text.toString()
            val stringResistencia = editTextResistencia.text.toString()
            val stringCorrente = editTextCorrente.text.toString()


            val tensao = stringTensao.toDoubleOrNull()
            val resistencia = stringResistencia.toDoubleOrNull()
            val corrente = stringCorrente.toDoubleOrNull()

            if ((stringTensao.isNotBlank() && tensao == null) ||
                (stringResistencia.isNotBlank() && resistencia == null) ||
                (stringCorrente.isNotBlank() && corrente == null)) {
                textViewResultado.text = getString(R.string.erro_entrada_invalida_numerica)
                return@setOnClickListener
            }

            val quantidadeValoresValidos = listOfNotNull(tensao, resistencia, corrente).size

            if (quantidadeValoresValidos < 2) {
                textViewResultado.text = getString(R.string.erro_valores_insuficientes)
            } else if (quantidadeValoresValidos > 2) {
                textViewResultado.text = getString(R.string.erro_valores_excedentes)
            } else {
                if (tensao == null && resistencia != null && corrente != null) {
                    val tensaoCalculada = resistencia * corrente
                    textViewResultado.text = getString(R.string.resultado_tensao, tensaoCalculada)
                } else if (resistencia == null && tensao != null && corrente != null) {
                    if (corrente == 0.0) {
                        textViewResultado.text = getString(R.string.erro_corrente_zero_para_resistencia)
                    } else {
                        val resistenciaCalculada = tensao / corrente
                        textViewResultado.text = getString(R.string.resultado_resistencia, resistenciaCalculada)
                    }
                } else if (corrente == null && tensao != null && resistencia != null) {
                    if (resistencia == 0.0) {
                        textViewResultado.text = getString(R.string.erro_resistencia_zero_para_corrente)
                    } else {
                        val correnteCalculada = tensao / resistencia
                        textViewResultado.text = getString(R.string.resultado_corrente, correnteCalculada)
                    }
                } else {
                    textViewResultado.text = getString(R.string.erro_logica_campos)
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

    }
}