package com.educode.examentottus.domain.usecases

import com.educode.examentottus.data.repository.TeamRepository
import com.educode.examentottus.domain.model.Team

class InsertTeam(private val teamRepository: TeamRepository) {
    suspend fun invoke( name: String, phrase: String, idUser: Int) {
        val team = Team(name,phrase,idUser)
        return teamRepository.insertTeam(team)
    }
}