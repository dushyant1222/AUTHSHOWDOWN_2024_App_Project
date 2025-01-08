package com.example.lookin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_option)



        val loginBtn=findViewById<Button>(R.id.Login_button)
        loginBtn.setOnClickListener {
            intent = Intent(applicationContext,SignIn :: class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_side_anim,R.anim.left_side_anim)
        }
        val clickText =findViewById<TextView>(R.id.new_here)
        clickText.setOnClickListener{
           intent = Intent(applicationContext,SignUp ::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_side_anim,R.anim.left_side_anim)
        }

    }

}