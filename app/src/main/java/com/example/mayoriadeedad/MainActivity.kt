package com.example.mayoriadeedad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Código para los márgenes
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscamos todos los elementos de la pantalla
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val btnComprobar = findViewById<Button>(R.id.btnComprobar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnSumar = findViewById<Button>(R.id.btnSumar)

        // Comprobar
        btnComprobar.setOnClickListener {
            val edadTexto = etEdad.text.toString()
            if (edadTexto.isEmpty()) {
                Toast.makeText(this, "Escribe un número primero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val edad = edadTexto.toInt()
            if (edad >= 18) {
                tvResultado.text = "Eres MAYOR de edad"
            } else {
                tvResultado.text = "Eres MENOR de edad"
            }
        }

        // Restar
        btnRestar.setOnClickListener {
            val edadTexto = etEdad.text.toString()
            if (edadTexto.isNotEmpty()) {
                val edad = edadTexto.toInt()
                if (edad > 0) {
                    etEdad.setText((edad - 1).toString())
                }
            } else {
                etEdad.setText("0")
            }
        }

        // Sumar
        btnSumar.setOnClickListener {
            val edadTexto = etEdad.text.toString()
            if (edadTexto.isNotEmpty()) {
                val edad = edadTexto.toInt()
                etEdad.setText((edad + 1).toString())
            } else {
                etEdad.setText("1")
            }
        }
    }
}