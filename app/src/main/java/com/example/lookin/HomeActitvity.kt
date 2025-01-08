package com.example.lookin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lookin.databinding.ActivityHomeActitvityBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class HomeActitvity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityHomeActitvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeActitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

         binding.homeout.setOnClickListener {
             if(auth.currentUser!=null){
                 auth.signOut()
                 startActivity(Intent(this,SignIn::class.java))
                 finish()
             }
             //for auto login
             val auth = Firebase.auth
             if(auth.currentUser!=null)
                 startActivity(Intent(this,HomeActitvity::class.java))
             finish()
         }

    }
}