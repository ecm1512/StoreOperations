package com.educode.examentottus.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.educode.examentottus.domain.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE mail = :mail and password = :password")
    fun autenticate(mail: String, password: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

}