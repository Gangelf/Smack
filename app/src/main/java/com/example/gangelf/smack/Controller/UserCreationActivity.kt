package com.example.gangelf.smack.Controller

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import android.widget.Toast
import com.example.gangelf.smack.R
import com.example.gangelf.smack.Services.AuthService
import com.example.gangelf.smack.Services.UserDataService
import com.example.gangelf.smack.Utilities.BROADCAST_USER_DATA_CHAANGE
import kotlinx.android.synthetic.main.activity_user_creation.*
import java.util.*

class UserCreationActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_creation)
        createSpinner.visibility = View.INVISIBLE
    }

    fun createGenerateAvatarClicked(view: View) {
        val random = Random()
        //generate number between 0 and 1
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        userAvatar = if (color == 0){
            "light$avatar"
        } else {
            "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createGenerateAvatarBtn.setImageResource(resourceId)

    }

    fun createGenBackColorClicked(view: View) {
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createGenerateAvatarBtn.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"
    }

    fun createUserClicked(view: View) {
        enableSpinner(true)
        val userName = createUserUserNameText.text.toString()
        val email = createEmailText.text.toString()
        val password = createPasswordText.text.toString()

        if (userName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            AuthService.registerUser( email, password) { registerSuccess ->
                if (registerSuccess) {
                    AuthService.loginUser( email, password) {loginSuccess ->
                        if (loginSuccess){
                            AuthService.createUser( email, password, userName, avatarColor, userAvatar ) { createSuccess ->
                                if(createSuccess) {

                                    val userDataChange = Intent(BROADCAST_USER_DATA_CHAANGE)
                                    LocalBroadcastManager.getInstance(this).sendBroadcast(userDataChange)

                                    enableSpinner(false)
                                    finish()
                                } else {
                                    errorToast()
                                }
                            }
                        } else {
                            errorToast()
                        }
                    }
                } else {
                    errorToast()
                }
            }
        } else {
            Toast.makeText(this, "Make sure the user name, email, amd password are filled in", Toast.LENGTH_LONG).show()
            enableSpinner(false)
        }
    }



    fun errorToast() {
        Toast.makeText(this, "Someting went wrong please try again", Toast.LENGTH_LONG).show()
        enableSpinner(false)
    }

    fun enableSpinner(enable: Boolean) {
        if(enable){
            createSpinner.visibility = View.VISIBLE
        } else {
            createSpinner.visibility = View.INVISIBLE
        }

        createUserBtn.isEnabled = !enable
        createGenerateAvatarBtn.isEnabled = !enable
        createGenBackColorBtn.isEnabled = !enable
    }
}
