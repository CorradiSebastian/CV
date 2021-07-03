package com.scorradi.cv.views.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.scorradi.cv.R
import com.scorradi.cv.views.main.MainActivity
import com.scorradi.cv.views.main.MainViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        viewModel.dataLoaded.observe(this, Observer(){
                dataLoaded -> if (dataLoaded) { gotoMain() }
        })

        viewModel.splashCreated()
    }

    private fun gotoMain(){
        //TODO load the json files and store them in ROOM
        Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 2000)
    }
}