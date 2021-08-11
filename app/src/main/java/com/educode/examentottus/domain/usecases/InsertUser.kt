package com.educode.examentottus.domain.usecases

import com.educode.examentottus.data.repository.UserRepository
import com.educode.examentottus.domain.model.User

class InsertUser(private val userRepository: UserRepository) {

    suspend fun invoke( mail: String, password: String,name:String, lastName: String) {
        val user = User(mail,password,name,lastName)
        return userRepository.insertUser(user)
    }
}