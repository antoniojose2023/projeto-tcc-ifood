package com.example.core

import android.app.Activity
import android.widget.Toast

fun Activity.MostrarMensagem(mensagem: String){
    Toast.makeText(
        applicationContext,
        "$mensagem",
        Toast.LENGTH_LONG).show()
}