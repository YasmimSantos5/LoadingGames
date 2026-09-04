package com.example.loadinggames

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cadastro)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmailCadastro)
        val edtSenha = findViewById<EditText>(R.id.edtSenhaCadastro)
        val edtConfirmarSenha = findViewById<EditText>(R.id.edtConfirmarSenha)

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val txtVoltarLogin = findViewById<TextView>(R.id.txtVoltarLogin)

        btnCadastrar.setOnClickListener {

            val nome = edtNome.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString()
            val confirmarSenha = edtConfirmarSenha.text.toString()

            // VALIDAÇÃO DO NOME
            if (nome.isEmpty()) {
                edtNome.error = "Digite seu nome"
                edtNome.requestFocus()
                return@setOnClickListener
            }

            if (nome.length < 3) {
                edtNome.error = "Digite um nome válido"
                edtNome.requestFocus()
                return@setOnClickListener
            }

            // VALIDAÇÃO DO E-MAIL
            if (email.isEmpty()) {
                edtEmail.error = "Digite seu e-mail"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.error = "Digite um e-mail válido"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            // VALIDAÇÃO DA SENHA
            if (senha.isEmpty()) {
                edtSenha.error = "Digite uma senha"
                edtSenha.requestFocus()
                return@setOnClickListener
            }

            if (senha.length < 6) {
                edtSenha.error = "A senha deve ter pelo menos 6 caracteres"
                edtSenha.requestFocus()
                return@setOnClickListener
            }

            // CONFIRMAÇÃO DA SENHA
            if (confirmarSenha.isEmpty()) {
                edtConfirmarSenha.error = "Confirme sua senha"
                edtConfirmarSenha.requestFocus()
                return@setOnClickListener
            }

            if (senha != confirmarSenha) {
                edtConfirmarSenha.error = "As senhas não são iguais"
                edtConfirmarSenha.requestFocus()
                return@setOnClickListener
            }

            // CADASTRO VÁLIDO
            Toast.makeText(
                this,
                "Conta criada com sucesso!",
                Toast.LENGTH_SHORT
            ).show()

            // VOLTAR PARA O LOGIN
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // VOLTAR PARA LOGIN
        txtVoltarLogin.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}