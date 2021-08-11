package com.educode.examentottus.domain.usecases

import com.educode.examentottus.data.repository.UserRepository
import com.educode.examentottus.domain.model.User

class Autenticate(private val userRepository: UserRepository) {
    suspend fun invoke(mail: String, password: String) : User{

        return userRepository.autenticate(mail, password)
    }
}