package com.example.thirstyfriend

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {
    private lateinit var numberPicker: NumberPicker
    private lateinit var botonContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        numberPicker = findViewById(R.id.numberPicker1)
        botonContinuar = findViewById(R.id.botonContinuar)

        // Configurar el NumberPicker
        numberPicker.apply {
            minValue = 1
            maxValue = 120  // Rango de edad
            value = 25  // Edad inicial

            // Quitar el teclado al hacer clic
            descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        }

        // Listener para cuando el valor cambia
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            Log.d("AgePicker", "Edad seleccionada: $newVal años")
        }

        // Acción del botón Continuar
        botonContinuar.setOnClickListener {
            val selectedAge = numberPicker.value
            Log.d("AgePicker", "Edad confirmada: $selectedAge años")
            // Aquí puedes añadir la lógica para continuar con la edad seleccionada
        }
    }
}
