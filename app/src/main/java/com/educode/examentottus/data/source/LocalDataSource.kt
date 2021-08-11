package com.educode.examentottus.data.source

import com.educode.examentottus.domain.model.Member
import com.educode.examentottus.domain.model.Team
import com.educode.examentottus.domain.model.User

interface LocalDataSource {
    fun autenticate(mail: String, password: String): User

    fun insertUser(user: User)

    fun insertTeam(team: Team)

    fun getTeam(idUser: Int): List<Team>

    fun insertMember(member: Member)

    fun getMember(idMember: Int): List<Member>
}