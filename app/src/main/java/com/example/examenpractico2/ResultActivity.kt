package com.example.examenpractico2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenpractico2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = intent.extras


        binding.tvResultado.text
        val str = """   DATOS
            Titulo: ${datos?.get("TITULO")}
            Nombre: ${datos?.get("NOMBRE")}
            edad: ${datos?.get("EDAD")}
            Curso: ${datos?.get("CURSOESCOLAR")}
            asignaturas: ${datos?.get("ASIGNATURAS")}
            pago: ${datos?.get("PAGO")}
        """.trimIndent()
        binding.tvResultado.text = str



        binding.btnVolver.setOnClickListener { onBackPressed() }
    }
}
