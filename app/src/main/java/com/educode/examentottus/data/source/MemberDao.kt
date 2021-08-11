package com.educode.examentottus.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.educode.examentottus.domain.model.Member
import com.educode.examentottus.domain.model.Team

@Dao
interface MemberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMember(member: Member)

    @Query("SELECT * FROM Member WHERE idTeam = :idTeam")
    fun getMember(idTeam: Int): List<Member>
}