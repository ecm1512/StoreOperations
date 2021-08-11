package com.educode.examentottus.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    val mail: String,
    val password: String,
    val name: String,
    val lastName: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

)