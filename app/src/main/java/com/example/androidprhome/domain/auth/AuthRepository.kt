package com.example.androidprhome.domain.auth

import com.example.androidprhome.model.UserModel

interface AuthRepository {
    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds(): UserModel

    fun doesUserExist(): Boolean

    fun userLogout()
}