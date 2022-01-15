package com.example.corona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.corona.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private  lateinit var binding: ActivityMainBinding
    private  lateinit var user:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()



        binding.btnlogin.setOnClickListener {
            registeruser()
            val  intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()

        }
haveAn.setOnClickListener{
    Toast.makeText(this, "Opening", Toast.LENGTH_SHORT).show()
}

    }
       private fun registeruser(){

          val email=binding.etEmail.text.toString()
          val password=binding.etPassword.text.toString()
           com.google.firebase.auth.FirebaseAuth.getInstance()
               .createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                   if (!it.isSuccessful) {
                       Toast.makeText(
                           applicationContext,
                           "Please check Email and Password",
                           Toast.LENGTH_SHORT
                       ).show()
                       return@addOnCompleteListener
                   } else {
                       Toast.makeText(
                           applicationContext,
                           "User Register Successful",
                           Toast.LENGTH_SHORT
                       ).show()
                   }
               }

       }
}



