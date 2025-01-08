package com.example.lookin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val SplashScreenTime : Long = 3500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash_screen)
        supportActionBar?.hide()
        // Load the blink animation
        val blinkText: TextView = findViewById<TextView>(R.id.techAnim)
        val blinkAnimation = AnimationUtils.
        loadAnimation(this, R.anim.blink_effect)
        blinkText.startAnimation(blinkAnimation)


        Handler().postDelayed({
            startActivity(Intent(this,SignInOption::class.java))
            finish()
        },5000)

//

    }
}