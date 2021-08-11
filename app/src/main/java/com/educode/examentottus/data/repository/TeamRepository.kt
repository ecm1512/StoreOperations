package com.educode.examentottus.data.repository

import com.educode.examentottus.data.source.LocalDataSource
import com.educode.examentottus.domain.model.Team


class TeamRepository(private val localDataSource: LocalDataSource) {
    suspend fun insertTeam(team: Team) {
        return localDataSource.insertTeam(team)
    }

    suspend fun getTeam(idUser: Int) : List<Team>{
        return localDataSource.getTeam(idUser)
    }
}