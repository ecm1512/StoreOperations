package com.educode.examentottus.data.source

import com.educode.examentottus.domain.model.Member
import com.educode.examentottus.domain.model.Team
import com.educode.examentottus.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TottusDbDataSource(db: TottusDatabase) : LocalDataSource {

    private val userDao = db.userDao()
    private val teamDao = db.teamDao()
    private val memberDao = db.memberDao()
    override fun autenticate(mail: String, password: String): User {
        return userDao.autenticate(mail,password)
    }

    override fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override fun insertTeam(team: Team) {
        teamDao.insertTeam(team)
    }

    override fun getTeam(idUser: Int): List<Team> {
        return teamDao.getTeam(idUser)
    }

    override fun insertMember(member: Member) {
        memberDao.insertMember(member)
    }

    override fun getMember(idTeam: Int): List<Member> {
        return memberDao.getMember(idTeam)
    }
}