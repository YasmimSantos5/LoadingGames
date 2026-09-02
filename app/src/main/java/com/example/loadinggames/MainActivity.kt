package com.example.loadinggames

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // CARD GOD OF WAR
        val cardGodOfWar = findViewById<LinearLayout>(R.id.cardGodOfWar)

        cardGodOfWar.setOnClickListener {
            abrirDetalhes(
                "God of War Ragnarök",
                R.drawable.god_of_war,
                "R$ 159,90",
                "AÇÃO • AVENTURA",
                "⭐ ⭐ ⭐ ⭐ ⭐  4.9",
                "Embarque em uma aventura épica com Kratos e Atreus. Explore novos mundos, enfrente inimigos poderosos e descubra uma história emocionante.",
                "Disponível para PS5"
            )
        }


        // CARD FC 24
        val cardFC24 = findViewById<LinearLayout>(R.id.cardFC24)

        cardFC24.setOnClickListener {
            abrirDetalhes(
                "EA SPORTS FC 24",
                R.drawable.fc24,
                "R$ 139,90",
                "ESPORTES • FUTEBOL",
                "⭐ ⭐ ⭐ ⭐  4.7",
                "Monte seu time dos sonhos e viva uma experiência completa de futebol com jogadores, clubes e competições de todo o mundo.",
                "Disponível para PS5"
            )
        }


        // CARD HOGWARTS
        val cardHogwarts = findViewById<LinearLayout>(R.id.cardHogwarts)

        cardHogwarts.setOnClickListener {
            abrirDetalhes(
                "Hogwarts Legacy",
                R.drawable.hogwarts,
                "R$ 149,90",
                "AÇÃO • RPG",
                "⭐ ⭐ ⭐ ⭐ ⭐  4.8",
                "Explore o mundo mágico de Hogwarts, aprenda feitiços, descubra segredos e viva sua própria aventura no universo bruxo.",
                "Disponível para PS5"
            )
        }
    }


    // FUNÇÃO PARA ABRIR A TELA DE DETALHES
    private fun abrirDetalhes(
        nome: String,
        imagem: Int,
        preco: String,
        categoria: String,
        avaliacao: String,
        descricao: String,
        plataforma: String
    ) {

        val intent = Intent(this, DetalhesActivity::class.java)

        intent.putExtra("nome", nome)
        intent.putExtra("imagem", imagem)
        intent.putExtra("preco", preco)
        intent.putExtra("categoria", categoria)
        intent.putExtra("avaliacao", avaliacao)
        intent.putExtra("descricao", descricao)
        intent.putExtra("plataforma", plataforma)

        startActivity(intent)
    }
}