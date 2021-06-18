package com.example.firebaseauthorisation.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauthorisation.R
import com.example.firebaseauthorisation.utils.FirebaseAuthButton
import com.example.firebaseauthorisation.utils.FirebaseAuthTextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        val tvUserId: FirebaseAuthTextView = findViewById(R.id.tv_user_id)
        val tvEmailId: FirebaseAuthTextView = findViewById(R.id.tv_email_id)

        tvUserId.text = "User ID :: $userId"
        tvEmailId.text = "Email ID :: $emailId"

        val btnLogout: FirebaseAuthButton = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }
}