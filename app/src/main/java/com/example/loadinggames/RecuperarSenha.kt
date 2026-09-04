package com.example.loadinggames

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EsqueciSenhaActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var btnRecuperarSenha: Button
    private lateinit var txtVoltarLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recuperar_senha)

        edtEmail = findViewById(R.id.edtEmailRecuperacao)
        btnRecuperarSenha = findViewById(R.id.btnRecuperarSenha)
        txtVoltarLogin = findViewById(R.id.txtVoltarLogin)

        btnRecuperarSenha.setOnClickListener {
            recuperarSenha()
        }

        txtVoltarLogin.setOnClickListener {
            finish()
        }
    }

    private fun recuperarSenha() {

        val email = edtEmail.text.toString().trim()

        if (email.isEmpty()) {
            edtEmail.error = "Digite seu e-mail"
            edtEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Digite um e-mail válido"
            edtEmail.requestFocus()
            return
        }

        // Recuperação provisória
        Toast.makeText(
            this,
            "Instruções de recuperação enviadas!",
            Toast.LENGTH_LONG
        ).show()
    }
}