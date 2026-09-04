
package com.example.loadinggames
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnEntrar: Button
    private lateinit var txtCadastrar: TextView
    private lateinit var txtEsqueciSenha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        // Referências dos componentes
        edtEmail = findViewById(R.id.edtEmail)
        edtSenha = findViewById(R.id.edtSenha)
        btnEntrar = findViewById(R.id.btnEntrar)
        txtCadastrar = findViewById(R.id.txtCadastrar)
        txtEsqueciSenha = findViewById(R.id.txtEsqueciSenha)

        // Botão entrar
        btnEntrar.setOnClickListener {
            validarLogin()
        }

        // Ir para cadastro
        txtCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        // Esqueci minha senha
        txtEsqueciSenha.setOnClickListener {
            val intent = Intent(this, EsqueciSenhaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validarLogin() {

        val email = edtEmail.text.toString().trim()
        val senha = edtSenha.text.toString().trim()

        // Verifica se o e-mail está vazio
        if (email.isEmpty()) {
            edtEmail.error = "Digite seu e-mail"
            edtEmail.requestFocus()
            return
        }

        // Verifica se o e-mail é válido
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Digite um e-mail válido"
            edtEmail.requestFocus()
            return
        }

        // Verifica se a senha está vazia
        if (senha.isEmpty()) {
            edtSenha.error = "Digite sua senha"
            edtSenha.requestFocus()
            return
        }

        // Verifica o tamanho da senha
        if (senha.length < 6) {
            edtSenha.error = "A senha deve ter pelo menos 6 caracteres"
            edtSenha.requestFocus()
            return
        }

        // =====================================
        // VALIDAÇÃO PROVISÓRIA
        // =====================================

        val emailTeste = "admin@loadinggames.com"
        val senhaTeste = "123456"

        if (email == emailTeste && senha == senhaTeste) {

            Toast.makeText(
                this,
                "Login realizado com sucesso!",
                Toast.LENGTH_SHORT
            ).show()

            // Abre a tela principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Impede voltar para a tela de login
            finish()

        } else {

            Toast.makeText(
                this,
                "E-mail ou senha incorretos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

