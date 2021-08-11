package com.educode.examentottus.domain.usecases

import com.educode.examentottus.data.repository.TeamRepository
import com.educode.examentottus.domain.model.Team

class GetTeam(private val teamRepository: TeamRepository) {
    suspend fun invoke(idUser: Int): List<Team> {
        return teamRepository.getTeam(idUser)
    }
}