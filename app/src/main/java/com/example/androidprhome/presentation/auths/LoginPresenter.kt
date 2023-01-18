package com.example.androidprhome.presentation.auths

import android.util.Log
import com.example.androidprhome.R
import com.example.androidprhome.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment){
        loginView = loginFragment
    }


    fun loginUser(userName: String, userPassword: String){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    authInteractor.loginUser(userName, userPassword)
                    loginView.userLoggedIn(R.id.action_loginFragment_to_homeFragment, R.id.loginFragment)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "loginUser FAILED")
            }

        }
    }
}