package com.example.trivia.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.trivia.R

class Trivia : Fragment() {
    private lateinit var viewModel: TriviaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_trivia, container, false)

        Log.i("EjemploBFragment", "Se llama a ViewModelProvider")
        viewModel = ViewModelProvider(this).get(TriviaViewModel::class.java)

        Toast.makeText(context, "Cantidad preguntas ${viewModel.cantidadPreguntasCorrectas}", Toast.LENGTH_SHORT).show()


        // para navegar a los distintos fragments
        val buttonIncorrecto: Button = binding.findViewById(R.id.button3)
        buttonIncorrecto.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_trivia_to_incorrectoFragment)
        }
        val buttonCorrecto: Button = binding.findViewById(R.id.button2)
        buttonCorrecto.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_trivia_to_correctoFragment)
        }
        return binding
    }
}