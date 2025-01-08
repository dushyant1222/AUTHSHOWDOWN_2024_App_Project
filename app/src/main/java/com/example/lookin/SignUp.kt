package com.example.lookin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.lookin.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.signUpbtn.setOnClickListener { CorrectInfo() }

//            intent = Intent(applicationContext, SignIn::class.java)
//            startActivity(intent)
                overridePendingTransition(R.anim.right_side_anim, R.anim.left_side_anim)

//        val forgetPass =findViewById<TextView>(R.id.forget)
//        binding.forget.setOnClickListener {
//            intent = Intent(applicationContext,ForgetActitvity ::class.java)
//            startActivity(intent)

    }

    private fun CorrectInfo() {
        val name = binding.name.text.toString()
        val email = binding.email.text.toString()
        val pass = binding.confirmLock.text.toString()
        if (checkedForm(name, email, pass)) {
            auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "User Id  created Successfully", Toast.LENGTH_LONG)
                            .show()
                        startActivity(Intent(this, HomeActitvity::class.java))
                        finish()
                    }
                    Toast.makeText(this, "Check your Email Id or Password", Toast.LENGTH_LONG)
                        .show()

                }
        }
    }

    fun checkedForm(name: String, email: String, password: String,): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                binding.name.error = "Invalid Name"
                false
            }

            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email)
                .matches() -> {
                binding.email.error = "Invalid Address"
                false
            }

            TextUtils.isEmpty((password)) -> {
                binding.confirmLock.error = "Wrong Password"
                false
            }

            else -> true
        }
    }
}





