package com.scorradi.cv.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.activityViewModels
import com.scorradi.cv.R
import com.scorradi.cv.databinding.FragmentMainBinding
import com.scorradi.cv.views.components.ExperienceItemAdapter
import com.scorradi.cv.views.events.Event
import com.scorradi.cv.views.fragments.JobFragment
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel
import java.util.*
import kotlin.random.Random

class MainFragment : Fragment() {

    //private val viewModel = MainViewModel by activityViewModels()


    private val binding get() = _binding
    private lateinit var _binding: FragmentMainBinding

    //private lateinit var viewModel:MainViewModel
    private val viewModel: MainViewModel by activityViewModels()

    companion object {

        fun newInstance(
        ) = MainFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        addObservers()
        lifecycle.addObserver(viewModel)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        return view
        //return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    private fun addObservers() {
        viewModel.person.observe(viewLifecycleOwner, {
            showPerson(it)
        })

        viewModel.experiences.observe(
            viewLifecycleOwner,
            Observer<List<ExperienceModel>> { experiences ->
                showExperiences(experiences)
            })

        viewModel.job.observe(viewLifecycleOwner, Observer<Event<JobModel>> { event ->
            val job = event.getContentIfNotHandledOrReturnNull()
            job?.let {
                showJob(job)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        removeObservers()
    }

    private fun removeObservers() {
        viewModel.person.removeObservers(viewLifecycleOwner)

        viewModel.experiences.removeObservers(viewLifecycleOwner)

        viewModel.job.removeObservers(viewLifecycleOwner)
    }

    fun showPerson(personModel: PersonModel) {
        binding.tvName.text = personModel.name
        binding.tvAge.text = resources.getString(R.string.age, personModel.age)
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

    fun showJob(jobModel: JobModel) {
        JobFragment.newInstance(jobModel).show(childFragmentManager, JobFragment.TAG)
    }
}