package com.scorradi.cv.views.main

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.scorradi.cv.databinding.ActivityMainBinding
import com.scorradi.cv.views.components.ExperienceItemAdapter
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.PersonModel

class MainActivity : Activity(), IMainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: MainPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvExperiences.layoutManager = linearLayoutManager

        presenter = MainPresenter(this)
        presenter.onCreate();

    }

    override fun showPerson(personModel: PersonModel){
        binding.tvName.text = personModel.Name
        binding.tvDNI.text = personModel.Id
        binding.tvAge.text = Integer.toString(personModel.Age)
        binding.tvPhoneNumber.text = personModel.PhoneNumber

    }

    override fun showExperiences(experiences: List<ExperienceModel>) {
        val adapter = ExperienceItemAdapter(experiences)
        binding.rvExperiences.adapter = adapter
        adapter.notifyDataSetChanged()


    }
}