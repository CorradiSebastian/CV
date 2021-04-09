package com.scorradi.cv.views.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.SharedElementCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.scorradi.cv.databinding.ActivityMainBinding
import com.scorradi.cv.views.components.ExperienceItemAdapter
import com.scorradi.cv.views.fragments.JobFragment
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvExperiences.layoutManager = linearLayoutManager

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.person.observe(this, Observer(){
            personModel -> showPerson(personModel)
        })

        viewModel.experiences.observe(this, Observer(){
            experiences -> showExperiences(experiences)
        })

        viewModel.job.observe(this, Observer(){
            event -> showJob(event.getContentIfNotHandledOrReturnNull())
        })

        viewModel.onCreate();
    }

    fun showPerson(personModel: PersonModel) {
        binding.tvName.text = personModel.name
        binding.tvDNI.text = personModel.id
        binding.tvAge.text = Integer.toString(personModel.age)
        binding.tvPhoneNumber.text = personModel.phoneNumber

    }

    fun showExperiences(experiences: List<ExperienceModel>) {
        val onClickListener = object : ExperienceItemAdapter.OnClickListener {
            override fun onClick(experienceModel: ExperienceModel) {
                viewModel.experienceModelClicked(experienceModel)
            }
        }

        val adapter = ExperienceItemAdapter(experiences, onClickListener)
        binding.rvExperiences.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun showJob(jobModel: JobModel?){
        jobModel?.let {
            JobFragment.newInstance(it).show(supportFragmentManager, JobFragment.TAG)
        }

    }


}