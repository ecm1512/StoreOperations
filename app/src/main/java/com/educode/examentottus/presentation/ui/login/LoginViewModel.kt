package com.educode.examentottus.presentation.ui.login


import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.educode.examentottus.domain.usecases.Autenticate
import java.lang.Exception

class LoginViewModel(private val autenticate: Autenticate, private val prefs: SharedPreferences): ViewModel() {

    fun autenticate(mail: String, password: String) = liveData<Boolean> {
        try {
            val response = autenticate.invoke(mail, password)
            with(prefs.edit()){
                putString("name",response.name)
                putString("mail",response.mail)
                putInt("id",response.id)
                apply()
            }
            if(response!=null){
                emit(true)
            }else emit(false)

        }catch (e: Exception){
            emit(false)
        }
    }

}