package com.educode.examentottus.presentation.ui.home.ui.team.dialog


import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.educode.examentottus.domain.usecases.InsertTeam
import kotlinx.coroutines.delay
import java.lang.Exception

class DialogViewModel(private val insertTeam: InsertTeam,private val prefs: SharedPreferences): ViewModel() {

    private val idUser:Int = prefs.getInt("id",0)

    fun insertTeam(mail: String, phrase: String) = liveData<Boolean> {
        try {
            val response = insertTeam.invoke(mail, phrase, idUser)
            delay(1000)
            emit(true)

        }catch (e: Exception){
            emit(false)
            Log.e("Dialog Fragment","${e.message}")
        }
    }
}