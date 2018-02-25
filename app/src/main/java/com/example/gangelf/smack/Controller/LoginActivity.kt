package com.example.gangelf.smack.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gangelf.smack.R
import com.example.gangelf.smack.Services.AuthService
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun loginLoginClicked(view: View) {
        val email = loginEmialText.text.toString()
        val password = loginPasswordText.text.toString()

        AuthService.loginUser(this, email, password) { loginSuccess ->
            if (loginSuccess) {
                AuthService.findUserByEmail(this) { findSuccess ->
                    if (findSuccess) {
                        finish()
                    }
                }
            }
        }
    }

    fun loginCreateUserClicked(view: View) {
        val createUserIntent = Intent(this, UserCreationActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }
}
