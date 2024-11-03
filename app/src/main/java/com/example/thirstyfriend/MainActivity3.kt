package com.example.thirstyfriend

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    private lateinit var botonHombre: ImageButton
    private lateinit var botonMujer: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Aplicar insets de sistema al contenedor principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar los botones
        botonHombre = findViewById(R.id.botonHombre)
        botonMujer = findViewById(R.id.botonMujer)

        // Configurar listeners para cambiar el estado seleccionado
        botonHombre.setOnClickListener {
            seleccionarGenero(true)
        }

        botonMujer.setOnClickListener {
            seleccionarGenero(false)
        }
    }

    // Función para cambiar el estado seleccionado
    private fun seleccionarGenero(esHombre: Boolean) {
        botonHombre.isSelected = esHombre
        botonMujer.isSelected = !esHombre
    }
}
