package com.apprikart.logindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apprikart.logindemo.databinding.ActivityMainBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var loginVM: LoginVM
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loginVM = ViewModelProvider(this).get(LoginVM::class.java)
        activityMainBinding.loginvm = loginVM
        activityMainBinding.lifecycleOwner = this
        observers()
    }

    private fun observers() {
        loginVM.toastUpdate.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        loginVM.intentUpdate.observe(this, Observer {
            launchHome()
        })
    }

    private fun launchHome() {
        val homeIntent = Intent(this, HomeScreen::class.java)
        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(homeIntent)
        finish()
    }

}