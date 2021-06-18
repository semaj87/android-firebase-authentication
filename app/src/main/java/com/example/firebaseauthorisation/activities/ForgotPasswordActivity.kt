package com.example.firebaseauthorisation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseauthorisation.R
import com.example.firebaseauthorisation.utils.FirebaseAuthButton
import com.example.firebaseauthorisation.utils.FirebaseAuthEditText
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val btnSubmit: FirebaseAuthButton = findViewById(R.id.btn_submit)
        val etForgotEmail: FirebaseAuthEditText = findViewById(R.id.et_forgot_email)
        btnSubmit.setOnClickListener {

            val email: String = etForgotEmail.text.toString().trim { it <= ' ' }

            if (email.isEmpty()) {
                Toast.makeText(
                    this@ForgotPasswordActivity,
                    "Please enter email.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "Email sent successfully to reset your password!",
                                Toast.LENGTH_LONG
                            ).show()

                            finish()
                        }
                        else {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
    }
}