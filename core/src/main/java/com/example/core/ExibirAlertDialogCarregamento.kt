package com.example.core

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup


class ExibirAlertDialogCarregamento(val context: Context) {

    var dialog : Dialog? = null

    @SuppressLint("InflateParams")
    val viewCarregamento = LayoutInflater.from(context).inflate(R.layout.load_carregamento, null,false)
    fun mostrarDialog(){
        val builder = AlertDialog.Builder(context)
            .setView( viewCarregamento )
            //.setTitle("Em Andamento . . . ")
            .setCancelable(false)

        dialog = builder.create()
        dialog?.show()
    }

    fun fecharDialog(){
        dialog?.setOnDismissListener {
             val viewGroup = viewCarregamento.parent as ViewGroup
            viewGroup.removeView( viewCarregamento )
        }
        dialog?.dismiss()
    }

}