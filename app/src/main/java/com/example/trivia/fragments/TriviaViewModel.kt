package com.example.trivia.fragments

import android.util.Log
import androidx.lifecycle.ViewModel

class TriviaViewModel: ViewModel() {

    var cantidadPreguntasCorrectas: Int = 0

    init {
        Log.i("EjemploBFragmentViewMod", "EjemploBFragmentViewModel creado")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("EjemploBFragmentViewMod", "EjemploBFragmentViewModel destruido")
    }
}