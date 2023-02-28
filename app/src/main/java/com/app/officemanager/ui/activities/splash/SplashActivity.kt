package com.app.officemanager.ui.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.officemanager.R
import com.app.officemanager.databinding.ActivitySplashBinding
import com.app.officemanager.ui.activities.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToNextScreen()
    }

    private fun navigateToNextScreen() {
        Handler(Looper.myLooper()!!).postDelayed({
            val intent: Intent by lazy {
                Intent(this, LoginActivity::class.java)
            }
            startActivity(intent)
            finish()
        }, 1000)
    }
}