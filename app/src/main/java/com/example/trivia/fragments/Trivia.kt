package com.example.trivia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trivia.R

class Trivia : Fragment() {
    private val args: TriviaArgs by navArgs()
    private var turnoActual = 0
    private lateinit var pregunta: TextView
    private lateinit var respuesta1: Button
    private lateinit var respuesta2: Button
    private lateinit var respuesta3: Button

    private val preguntas = arrayOf(
        mutableMapOf(
            "question" to "¿Cuántas franjas tiene la bandera de Estados Unidos?",
            "choices" to listOf("12", "14", "13"),
            "correct" to "13"
        ),
        mutableMapOf(
            "question" to "¿Cuál es el río más largo del mundo?",
            "choices" to listOf("Nilo", "Misisipi", "Yangtsé"),
            "correct" to "Nilo"
        ),
        mutableMapOf(
            "question" to "¿Cuál es el animal terrestre más rápido del mundo?",
            "choices" to listOf("Guepardo", "Rinoceronte", "Venado"),
            "correct" to "Guepardo"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_trivia, container, false)

        turnoActual = args.numeroPreguntas

        Toast.makeText(context, "Turno Actual ${turnoActual}", Toast.LENGTH_SHORT).show()


        // para navegar a los distintos fragments
        pregunta = binding.findViewById(R.id.pregunta)
        pregunta.text = preguntas[turnoActual]["question"].toString()
        respuesta1 = binding.findViewById(R.id.respuesta1)
        respuesta2 = binding.findViewById(R.id.respuesta2)
        respuesta3 = binding.findViewById(R.id.respuesta3)

        val opciones = preguntas[turnoActual]["choices"] as List<String>

        respuesta1.text = opciones[0]
        respuesta2.text = opciones[1]
        respuesta3.text = opciones[2]

        respuesta1.setOnClickListener { verificarRespuesta(respuesta1.text.toString()) }
        respuesta2.setOnClickListener { verificarRespuesta(respuesta2.text.toString()) }
        respuesta3.setOnClickListener { verificarRespuesta(respuesta3.text.toString()) }

        return binding
    }

    private fun verificarRespuesta(text: String) {
        if (text == preguntas[turnoActual]["correct"]) {
            val direction = TriviaDirections.actionTriviaToCorrectoFragment(turnoActual)
            findNavController().navigate(direction)
        } else {
            val direction = TriviaDirections.actionTriviaToIncorrectoFragment(turnoActual)
            findNavController().navigate(direction)
        }

    }
}