package com.scorradi.cv.views.main

import android.app.Activity
import android.os.Bundle
import com.scorradi.cv.databinding.ActivityMainBinding
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.views.models.PersonModel

class MainActivity : Activity(), IMainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: MainPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = MainPresenter(this)
        presenter.onCreate();

    }

    override fun showPerson(personModel: PersonModel){
        binding.tvName.text = personModel.Name
        binding.tvDNI.text = personModel.Id
        binding.tvAge.text = Integer.toString(personModel.Age)
        binding.tvPhoneNumber.text = personModel.PhoneNumber
    }

    override fun showExperiences(experiences: List<Experience>) {
        TODO("Not yet implemented")
    }
}