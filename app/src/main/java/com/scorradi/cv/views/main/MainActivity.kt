package com.scorradi.cv.views.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scorradi.cv.R
import com.scorradi.cv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_activity_main_container, MainFragment.newInstance())
        transaction.addToBackStack(null)
        transaction.commit()*/
    }


}