package com.educode.examentottus.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Member (
    val name: String,
    val mail: String,
    val idTeam: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

)

