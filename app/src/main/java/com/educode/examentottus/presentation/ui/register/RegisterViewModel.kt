package com.educode.examentottus.presentation.ui.register

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.educode.examentottus.domain.usecases.Autenticate
import com.educode.examentottus.domain.usecases.InsertUser
import kotlinx.coroutines.delay
import java.lang.Exception

class RegisterViewModel(private val insertUser: InsertUser): ViewModel()  {
    fun insertUser(mail: String, password: String, name:String, lastName:String) = liveData<Boolean> {
        try {
            val response = insertUser.invoke(mail, password, name, lastName)
            delay(1000)
            emit(true)

        }catch (e: Exception){
            emit(false)
            Log.e("Register Activity","${e.message}")
        }
    }
}