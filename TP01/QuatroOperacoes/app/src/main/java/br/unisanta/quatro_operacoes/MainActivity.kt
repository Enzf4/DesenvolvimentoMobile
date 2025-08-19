package br.unisanta.quatro_operacoes

import android.os.Bundle
import android.view.Gravity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumero1: EditText
    private lateinit var editTextNumero2: EditText
    private lateinit var botaoSoma: Button // Agora para Soma
    private lateinit var botaoSubtracao: Button
    private lateinit var botaoMultiplicacao: Button
    private lateinit var botaoDivisao: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editTextNumero1 = findViewById(R.id.edt_num1)
        editTextNumero2 = findViewById(R.id.edt_num2)
        botaoSoma = findViewById(R.id.btn_calculo)
        botaoSubtracao = findViewById(R.id.btn_subtracao)
        botaoMultiplicacao = findViewById(R.id.btn_multiplicacao)
        botaoDivisao = findViewById(R.id.btn_divisao)
        textViewResultado = findViewById(R.id.txv_resultado)
        textViewResultado.gravity = Gravity.CENTER
        // Listener para o botão de Soma (botaoSoma)
        botaoSoma.setOnClickListener { realizarSoma() }

        // Listeners para as operações aritméticas
        botaoSubtracao.setOnClickListener { realizarSubtracao() }
        botaoMultiplicacao.setOnClickListener { realizarMultiplicacao() }
        botaoDivisao.setOnClickListener { realizarDivisao() }

    }

    private fun obterNumeros(): Pair<Double, Double>? {

            val numero1 = editTextNumero1.text.toString().toDouble()
            val numero2 = editTextNumero2.text.toString().toDouble()
            return Pair(numero1, numero2)

    }

    private fun realizarSoma() {
        val (numero1, numero2) = obterNumeros() ?: return
        val resultado = numero1 + numero2
        textViewResultado.text = "Resultado da Soma: %.2f".format(resultado)
    }

    private fun realizarSubtracao() {
        val (numero1, numero2) = obterNumeros() ?: return
        val resultado = numero1 - numero2
        textViewResultado.text = "Resultado da Subtração: %.2f".format(resultado)
    }

    private fun realizarMultiplicacao() {
        val (numero1, numero2) = obterNumeros() ?: return
        val resultado = numero1 * numero2
        textViewResultado.text = "Resultado da Multiplicação: %.2f".format(resultado)
    }

    private fun realizarDivisao() {
        val (numero1, numero2) = obterNumeros() ?: return
        if (numero2 == 0.0) {
            textViewResultado.text = "Erro: Divisão por zero."
            return
        }
        val resultado = numero1 / numero2
        textViewResultado.text = "Resultado da Divisão: %.2f".format(resultado)
    }
}

