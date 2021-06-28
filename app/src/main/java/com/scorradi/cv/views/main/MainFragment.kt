package com.scorradi.cv.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.scorradi.cv.databinding.FragmentMainBinding
import com.scorradi.cv.views.components.ExperienceItemAdapter
import com.scorradi.cv.views.fragments.JobFragment
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.JobModel
import com.scorradi.cv.views.models.PersonModel
import java.util.*

class MainFragment : Fragment() {

    //private val viewModel = MainViewModel by activityViewModels()


    private val binding get() = _binding
    private lateinit var _binding: FragmentMainBinding
    private lateinit var viewModel:MainViewModel

    companion object {

        fun newInstance(
        ) = MainFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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

    private fun addObservers(){
        viewModel.person.observe(viewLifecycleOwner, Observer<PersonModel>{
                showPerson(it)
        })

        viewModel.experiences.observe(viewLifecycleOwner, Observer<List<ExperienceModel>>{ experiences ->
            showExperiences(experiences)
        })

        viewModel.job.observe(viewLifecycleOwner, Observer<JobModel>{ job ->
                 showJob(job)
        })
    }

    private fun removeObservers(){
        viewModel.person.removeObservers(viewLifecycleOwner)

        viewModel.experiences.removeObservers(viewLifecycleOwner)

        viewModel.job.removeObservers(viewLifecycleOwner)
    }

    fun showPerson(personModel: PersonModel) {
        binding.tvName.text = personModel.Name
        binding.tvDNI.text = personModel.Id
        binding.tvAge.text = Integer.toString(personModel.Age)
        binding.tvPhoneNumber.text = personModel.PhoneNumber

    }

    fun showExperiences(experiences: List<ExperienceModel>) {
        val onClickListener = object : ExperienceItemAdapter.OnClickListener {
            override fun onClick(experienceModel: ExperienceModel) {
                viewModel.onExperienceModelClick(experienceModel)
            }
        }

        val adapter = ExperienceItemAdapter(experiences, onClickListener)
        binding.rvExperiences.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun showJob(jobModel: JobModel){
        JobFragment.newInstance(jobModel).show(childFragmentManager, JobFragment.TAG)
    }
}