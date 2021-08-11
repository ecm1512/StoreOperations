package com.educode.examentottus.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.educode.examentottus.domain.model.Team

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team: Team)

    @Query("SELECT * FROM Team WHERE idUser = :idUser")
    fun getTeam(idUser: Int): List<Team>
}