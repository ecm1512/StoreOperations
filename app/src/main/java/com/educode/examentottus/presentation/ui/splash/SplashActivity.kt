package com.educode.examentottus.presentation.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.educode.examentottus.R
import com.educode.examentottus.presentation.ui.MainActivity
import com.educode.examentottus.presentation.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        }, 5000)
    }
}