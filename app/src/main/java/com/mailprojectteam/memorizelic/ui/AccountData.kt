package com.mailprojectteam.memorizelic.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mailprojectteam.memorizelic.R
import com.mailprojectteam.memorizelic.ui.notifications.NotificationsFragment

class AccountData : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_data)

        val user = intent.extras?.getString("username")
        val mail = intent.extras?.getString("email")
        val pass = intent.extras?.getString("password")
        val username1: TextView = findViewById<TextView>(R.id.account_data_real_username)
        username1.text = user
        val email: TextView = findViewById<TextView>(R.id.account_real_email)
        email.text = mail
        val password: TextView = findViewById<TextView>(R.id.account_real_password)
        password.text = pass

        val signInButton: Button = findViewById(R.id.button_log_out);
        signInButton.setOnClickListener {
            val intent = Intent(this@AccountData, NotificationsFragment::class.java)
            startActivity(intent)
        }
    }
}