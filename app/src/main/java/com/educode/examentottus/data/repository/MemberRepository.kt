package com.educode.examentottus.data.repository

import com.educode.examentottus.data.source.LocalDataSource
import com.educode.examentottus.domain.model.Member

class MemberRepository(private val localDataSource: LocalDataSource)  {
    suspend fun insertMember(member: Member) {
        return localDataSource.insertMember(member)
    }

    suspend fun getMember(idTeam: Int) : List<Member>{
        return localDataSource.getMember(idTeam)
    }
}