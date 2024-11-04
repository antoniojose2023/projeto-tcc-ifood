package com.example.appifoodtcc.domain.usecase

import android.app.Activity
import android.content.Context
import android.os.Binder
import android.os.Build
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
fun Activity.EsconderTeclado(){

//    val inputMethod = getSystemService(InputMethodManager::class.java)
//
//    if(inputMethod.isActive){
//        inputMethod.toggleSoftInput(
//             InputMethodManager.HIDE_IMPLICIT_ONLY,
//             0
//        )
//    }


      val inputMethod = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      val windowToken = Binder()
      inputMethod.hideSoftInputFromWindow(
          windowToken,
         0
      )
}