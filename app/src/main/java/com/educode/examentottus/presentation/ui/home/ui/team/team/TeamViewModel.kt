package com.educode.examentottus.presentation.ui.home.ui.team.team

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.educode.examentottus.domain.model.Team
import com.educode.examentottus.domain.usecases.GetTeam
import kotlinx.coroutines.launch

class TeamViewModel(private val getTeam : GetTeam,private val prefs: SharedPreferences) : ViewModel() {

    private val _dataTeam = MutableLiveData<List<Team>>()
    val data: LiveData<List<Team>> get() = _dataTeam

    fun getTeam(){
        viewModelScope.launch {
            try{
                val response = getTeam.invoke(prefs.getInt("id",0))
                if(response!=null){
                    _dataTeam.value = response
                }else{

                }
            }catch (e: Exception){

            }
        }
    }

}