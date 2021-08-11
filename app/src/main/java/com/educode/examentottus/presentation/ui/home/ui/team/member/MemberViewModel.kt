package com.educode.examentottus.presentation.ui.home.ui.team.member

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.*
import com.educode.examentottus.domain.model.Member
import com.educode.examentottus.domain.usecases.GetMember
import com.educode.examentottus.domain.usecases.InsertMember
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MemberViewModel(private val getMember : GetMember, private val insertMember: InsertMember) : ViewModel() {
    private val _dataMember = MutableLiveData<List<Member>>()
    val data: LiveData<List<Member>> get() = _dataMember

    fun getMember(idTeam: Int){
        viewModelScope.launch {
            try{
                val response = getMember.invoke(idTeam)
                if(response!=null){
                    _dataMember.value = response
                }else{

                }
            }catch (e: Exception){

            }
        }
    }

    fun insertMember(name: String, mail: String, idTeam:Int) = liveData<Boolean> {
        try {
            val response = insertMember.invoke(name, mail, idTeam)
            delay(1000)
            emit(true)

        }catch (e: java.lang.Exception){
            emit(false)
        }
    }
}