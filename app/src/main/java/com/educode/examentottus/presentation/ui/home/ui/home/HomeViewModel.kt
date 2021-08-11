package com.educode.examentottus.presentation.ui.home.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(private val prefs: SharedPreferences) : ViewModel() {


    private val _textName = MutableLiveData<String>().apply {
        value = prefs.getString("name","")
    }
    val textName: LiveData<String> = _textName

    private val _textMail = MutableLiveData<String>().apply {
        value = prefs.getString("mail","")
    }
    val textMail: LiveData<String> = _textMail
}