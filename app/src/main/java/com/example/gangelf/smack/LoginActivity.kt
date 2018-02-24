package com.example.gangelf.smack

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun loginLoginClicked(view: View) {

    }

    fun loginCreateUserClicked(view: View) {
        val createUserIntent = Intent(this, UserCreationActivity::class.java)
        startActivity(createUserIntent)

    }
}
