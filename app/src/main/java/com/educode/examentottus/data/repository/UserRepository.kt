package com.educode.examentottus.data.repository

import com.educode.examentottus.data.source.LocalDataSource
import com.educode.examentottus.domain.model.User

class UserRepository(private val localDataSource: LocalDataSource) {

    suspend fun autenticate(mail: String, password: String): User {
        return localDataSource.autenticate(mail,password)
    }

    suspend fun insertUser(user: User) {
        return localDataSource.insertUser(user)
    }

}