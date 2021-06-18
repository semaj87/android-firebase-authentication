package com.example.firebaseauthorisation.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauthorisation.R
import com.example.firebaseauthorisation.utils.FirebaseAuthButton
import com.example.firebaseauthorisation.utils.FirebaseAuthEditText
import com.example.firebaseauthorisation.utils.FirebaseAuthTextViewBold
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val tvForgotPassword: FirebaseAuthTextViewBold = findViewById(R.id.tv_forgot_password)
        tvForgotPassword.setOnClickListener {

            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        val btnRegister: FirebaseAuthButton = findViewById(R.id.btn_register)

        btnRegister.setOnClickListener {
            val etEmail: FirebaseAuthEditText = findViewById(R.id.et_email)
            val etPassword: FirebaseAuthEditText = findViewById(R.id.et_password)
            when {
                TextUtils.isEmpty(etEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter an email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(etPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter a password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val email: String = etEmail.text.toString().trim { it <= ' ' }
                    val password: String = etPassword.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                                if (task.isSuccessful) {

                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@RegisterActivity,
                                        "You were registered successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@RegisterActivity, MainActivity::class.java)
                                    // Removing old activities on the stack
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()
                                }
                                else {
                                    Toast.makeText(
                                        this@RegisterActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }
        }
    }
}