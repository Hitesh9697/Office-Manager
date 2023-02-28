package com.app.officemanager.ui.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.officemanager.databinding.ActivityLoginBinding
import com.app.officemanager.ui.activities.BaseActivity
import com.app.officemanager.ui.activities.home_dashboard.HomeDashboardActivity

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initListener() {
        binding.apply {
            cvLogin.setOnClickListener(this@LoginActivity)
        }
    }

    override fun initObserver() {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        binding.apply {
            when(v) {
                cvLogin -> {
                    startActivity(Intent(this@LoginActivity, HomeDashboardActivity::class.java))
                }
            }
        }
    }
}