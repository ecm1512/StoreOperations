package com.educode.examentottus.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import retrofit2.Converter

@Entity
data class Team(

    val name: String,
    val phrase: String,
    val idUser: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

)