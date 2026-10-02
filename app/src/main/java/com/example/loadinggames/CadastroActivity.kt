package com.example.loadinggames

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.loadinggames.api.CadastroRequest
import com.example.loadinggames.api.CadastroResponse
import com.example.loadinggames.api.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cadastro)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmailCadastro)
        val edtSenha = findViewById<EditText>(R.id.edtSenhaCadastro)
        val edtConfirmarSenha =
            findViewById<EditText>(R.id.edtConfirmarSenha)

        val btnCadastrar =
            findViewById<Button>(R.id.btnCadastrar)

        val txtVoltarLogin =
            findViewById<TextView>(R.id.txtVoltarLogin)

        btnCadastrar.setOnClickListener {

            val nome = edtNome.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString()
            val confirmarSenha =
                edtConfirmarSenha.text.toString()

            // NOME
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

            // E-MAIL
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

            // SENHA
            if (senha.isEmpty()) {
                edtSenha.error = "Digite uma senha"
                edtSenha.requestFocus()
                return@setOnClickListener
            }

            if (senha.length < 6) {
                edtSenha.error =
                    "A senha deve ter pelo menos 6 caracteres"
                edtSenha.requestFocus()
                return@setOnClickListener
            }

            // CONFIRMAR SENHA
            if (confirmarSenha.isEmpty()) {
                edtConfirmarSenha.error = "Confirme sua senha"
                edtConfirmarSenha.requestFocus()
                return@setOnClickListener
            }

            if (senha != confirmarSenha) {
                edtConfirmarSenha.error =
                    "As senhas não são iguais"
                edtConfirmarSenha.requestFocus()
                return@setOnClickListener
            }

            // ENVIA PARA A API
            val cadastroRequest = CadastroRequest(
                nome = nome,
                email = email,
                senha = senha
            )

            RetrofitClient.api.cadastrar(cadastroRequest)
                .enqueue(object : Callback<CadastroResponse> {

                    override fun onResponse(
                        call: Call<CadastroResponse>,
                        response: Response<CadastroResponse>
                    ) {

                        if (response.isSuccessful) {

                            Toast.makeText(
                                this@CadastroActivity,
                                response.body()?.mensagem
                                    ?: "Conta criada com sucesso!",
                                Toast.LENGTH_SHORT
                            ).show()

                            // VOLTA PARA O LOGIN
                            val intent = Intent(
                                this@CadastroActivity,
                                LoginActivity::class.java
                            )

                            startActivity(intent)
                            finish()

                        } else {

                            Toast.makeText(
                                this@CadastroActivity,
                                "Não foi possível criar a conta. Verifique se o e-mail já está cadastrado.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onFailure(
                        call: Call<CadastroResponse>,
                        t: Throwable
                    ) {

                        Toast.makeText(
                            this@CadastroActivity,
                            "Erro ao conectar com o servidor: ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }

        // VOLTAR PARA LOGIN
        txtVoltarLogin.setOnClickListener {

            val intent = Intent(
                this,
                LoginActivity::class.java
            )

            startActivity(intent)
            finish()
        }
    }
}