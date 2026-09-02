package com.example.loadinggames

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhes)

        // COMPONENTES DA TELA
        val imgJogo = findViewById<ImageView>(R.id.imgJogo)
        val txtNomeJogo = findViewById<TextView>(R.id.txtNomeJogo)
        val txtAvaliacao = findViewById<TextView>(R.id.txtAvaliacao)
        val txtDescricao = findViewById<TextView>(R.id.txtDescricao)
        val txtPreco = findViewById<TextView>(R.id.txtPreco)

        val btnAdicionarCarrinho =
            findViewById<Button>(R.id.btnAdicionarCarrinho)

        val btnFavorito =
            findViewById<Button>(R.id.btnFavorito)


        // RECEBER DADOS DA MAIN ACTIVITY
        val nome = intent.getStringExtra("nome")
        val imagem = intent.getIntExtra("imagem", 0)
        val preco = intent.getStringExtra("preco")
        val categoria = intent.getStringExtra("categoria")
        val avaliacao = intent.getStringExtra("avaliacao")
        val descricao = intent.getStringExtra("descricao")
        val plataforma = intent.getStringExtra("plataforma")


        // PREENCHER A TELA
        txtNomeJogo.text = nome
        txtAvaliacao.text = avaliacao
        txtDescricao.text = descricao
        txtPreco.text = preco

        if (imagem != 0) {
            imgJogo.setImageResource(imagem)
        }


        // BOTÃO CARRINHO
        btnAdicionarCarrinho.setOnClickListener {

            Toast.makeText(
                this,
                "$nome adicionado ao carrinho!",
                Toast.LENGTH_SHORT
            ).show()
        }


        // BOTÃO FAVORITO
        btnFavorito.setOnClickListener {

            Toast.makeText(
                this,
                "$nome adicionado aos favoritos!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}