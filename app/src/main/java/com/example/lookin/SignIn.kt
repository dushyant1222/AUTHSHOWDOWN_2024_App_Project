//package com.example.lookin
//
//import android.app.Activity
//import android.content.ContentProviderClient
//import android.content.Intent
//import android.os.Bundle
//import android.text.TextUtils
//import android.util.Patterns
//import android.widget.CheckBox
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.appcompat.app.AppCompatActivity
//import com.example.lookin.databinding.ActivitySignInBinding
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.tasks.Task
//import com.google.firebase.Firebase
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.GoogleAuthProvider
//import com.google.firebase.auth.auth
//import kotlin.math.sign
//
//
//class SignIn : AppCompatActivity() {
//    private lateinit var auth: FirebaseAuth
//    private lateinit var binding: ActivitySignInBinding
//    private lateinit var googleSignInClient:GoogleSignInClient
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySignInBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        auth = Firebase.auth
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//
//
//        binding.justSign.setOnClickListener {
//
//            userlogin()
//            loginWithGoogle()
//
//        }
//        binding.loginBtn.setOnClickListener {
//
//            userlogin()
//        }
//        binding.justSign.setOnClickListener {
//            intent = Intent(applicationContext, SignUp::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.right_side_anim, R.anim.left_side_anim)
//        }
//
//        binding.forget.setOnClickListener {
//            Toast.makeText(this, "Not yet Implemented", Toast.LENGTH_LONG).show()
//            intent = Intent(applicationContext, ForgetActitvity::class.java)
//            startActivity(intent)
//        }
//    }
//
//
//
//
//
//
//    private fun userlogin()
//    {
//        val email = binding.email.text.toString()
//        val pass = binding.pass.text.toString()
//        if (checkedForm(email, pass)) {
//            auth.signInWithEmailAndPassword(email, pass)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        startActivity(Intent())
//                        finish()
//                    }
//                    else {
//                        Toast.makeText(this, "Cannot Sign In , Please try again", Toast.LENGTH_LONG).show()
//                    }
//                }
//
//        }
//    }
//        private fun loginWithGoogle(){
//
//                val loginIntent = googleSignInClient.signInIntent
//                launcher.launch(loginIntent)
//        }
//
//
////        val loginIntent =googleSignInClient.signInIntent
////            .launcher.launch(loginIntent)
//
//      private val launcher =registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//      {result->
//        if(result.resultCode == Activity.RESULT_OK)
//        {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//            handleResult(task)
//        }
//    }
//
//    private fun handleResult(task: Task<GoogleSignInAccount>) {
//        if(task.isSuccessful)
//        {
//            val account:GoogleSignInAccount = task.result
//            if (account!=null)
//                updateUI(account)
//        }else{
//            Toast.makeText(this,"Sign In Failed, Try again later",Toast.LENGTH_LONG).show()
//        }
//
//
//    }
//
//    private fun updateUI(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
//        auth.signInWithCredential(credential).addOnCompleteListener {
//            if (it.isSuccessful) {
//                        startActivity(Intent())
//                        finish()
//                    }
//                    else {
//                        Toast.makeText(this, "Cannot Sign In , Please try again", Toast.LENGTH_LONG).show()
//                    }
//                }
//
//            }
//
//
//    private fun checkedForm(email: String, pass: String,): Boolean
//    {
//        return when
//        {
//
//            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email)
//                .matches() -> {
//                binding.email.error = "Invalid Address"
//                false
//            }
//
//            TextUtils.isEmpty((pass)) -> {
//                binding.pass.error = "Wrong Password"
//                false
//            }else -> {true}
//        }
//    }
//}
//
//
//
//
//
//
//

package com.example.lookin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lookin.databinding.ActivitySignInBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignIn : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignInBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.justSign.setOnClickListener {
            intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_side_anim, R.anim.left_side_anim)
        }

        binding.LoginButton.setOnClickListener {
            userLogin()
        }
        binding.goolelogin.setOnClickListener{
            loginWithGoogle()
        }

        binding.forget.setOnClickListener {
            //Toast.makeText(this, "Not yet Implemented", Toast.LENGTH_LONG).show()
            intent = Intent(applicationContext, ForgetActitvity::class.java)
            startActivity(intent)
        }

        binding.justSign.setOnClickListener {
            intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
        }

    }

    private fun userLogin() {
        val email = binding.email.text.toString()
        val pass = binding.pass.text.toString()

        if (validateForm(email, pass)) {
            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, HomeActitvity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Cannot Sign In, Please try again", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun loginWithGoogle() {
        val loginIntent = googleSignInClient.signInIntent
        launcher.launch(loginIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResult(task)
        }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            account?.let {
                updateUI(it)
            }
        } else {
            Toast.makeText(this, "Sign In Failed, Try again later", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                startActivity(Intent(this, HomeActitvity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Cannot Sign In, Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateForm(email: String, pass: String): Boolean {
        return when {
            TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding.email.error = "Invalid Address"
                false
            }
            TextUtils.isEmpty(pass) -> {
                binding.pass.error = "Wrong Password"
                false
            }
            else -> true
        }
    }
}
