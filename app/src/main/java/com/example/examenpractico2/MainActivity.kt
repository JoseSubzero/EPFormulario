package com.example.examenpractico2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import com.bumptech.glide.Glide
import com.example.examenpractico2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var curso = arrayOf("")
    var pago = "Efectivo"
    var asignaturas = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imView = findViewById<ImageView>(R.id.ivCara)
        Glide.with(this)

        getSpinner(this, binding.spCurso, curso, R.array.CursoEscolar)

        binding.btnEnviar.setOnClickListener { getAndSend() }
    }
    fun getAndSend(){
        val myIntent = Intent(this, ResultActivity::class.java)
        myIntent.putExtra("TITULO", binding.tvTitulo.text.toString())
        myIntent.putExtra("NOMBRE", binding.etNombre.text.toString())
        myIntent.putExtra("EDAD", binding.etEdad.text.toString())
        myIntent.putExtra("CURSOESCOLAR", curso[0])
        myIntent.putExtra("PAGO", pago)
        myIntent.putExtra("ASIGNATURAS", asignaturas.toString())
        startActivity(myIntent)
    }
    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val ckName = view.text.toString()
            if (view.isChecked){
                if (!asignaturas.contains(ckName)) {asignaturas.add(ckName)}
            } else {
                if (asignaturas.contains(ckName)) {asignaturas.remove(ckName)}
            }
        }
    }
    fun onRadioClicked(view: View){
        if (view is RadioButton){
            pago = view.text.toString()
        }
    }
}

