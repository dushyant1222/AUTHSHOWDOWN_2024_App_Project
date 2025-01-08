package com.example.lookin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lookin.databinding.ActivityForgetActitvityBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ForgetActitvity : AppCompatActivity() {
    private  lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityForgetActitvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgetActitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        }








    }
