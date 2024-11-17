package com.example.thirstyfriend

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class Principal : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var tvCantidadAgua: TextView
    private lateinit var tvHistorial: TextView
    private var progresoActual = 0
    private val OBJETIVO_DIARIO = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)

        // Ajustar márgenes para insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        // Referenciar vistas
        progressBar = findViewById(R.id.progressBar)
        tvCantidadAgua = findViewById(R.id.tvCantidadAgua)
        tvHistorial = findViewById(R.id.tvHistorial)
        val btnMas: ImageButton = findViewById(R.id.btnMas)

        // Configurar evento de clic
        btnMas.setOnClickListener {
            agregarAgua(100) // Incrementar el progreso en 100 ml
        }
    }

    private fun agregarAgua(cantidad: Int) {
        if (progresoActual + cantidad <= OBJETIVO_DIARIO) {
            progresoActual += cantidad
            progressBar.progress = progresoActual
            tvCantidadAgua.text = "$progresoActual/$OBJETIVO_DIARIO ml"

            // Actualizar historial
            val horaActual = java.text.DateFormat.getTimeInstance().format(java.util.Date())
            val nuevoRegistro = "$horaActual - ${cantidad}ml\n${tvHistorial.text}"
            tvHistorial.text = nuevoRegistro
        }
    }
}
