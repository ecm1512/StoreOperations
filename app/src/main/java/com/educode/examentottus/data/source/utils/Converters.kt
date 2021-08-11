package com.educode.examentottus.data.source.utils

import androidx.room.TypeConverter
import com.educode.examentottus.domain.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun fromListUsers(lista: List<User>):String{
        return Gson().toJson(lista)
    }
    @TypeConverter
    fun toListUsers(datos: String):List<User>{
        val listType: Type = object : TypeToken<ArrayList<User?>?>() {}.type
        return Gson().fromJson(datos, listType)
    }
}