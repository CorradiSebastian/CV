package com.scorradi.cv.views.professionaldevelopment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.scorradi.cv.databinding.FragmentProfessionalDevelopmentBinding
import com.scorradi.cv.db.daos.entities.Technology
import com.scorradi.cv.views.components.TechnologyItemAdapter

class ProfessionalDevelopmentFragment: Fragment() {
    private val binding get() = _binding
    private lateinit var _binding: FragmentProfessionalDevelopmentBinding

    //private lateinit var viewModel:MainViewModel
    private val viewModel: ProfessionalDevelopmentViewModel by activityViewModels()

    companion object {

        fun newInstance(
        ) = ProfessionalDevelopmentFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfessionalDevelopmentBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        lifecycle.addObserver(viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        removeObservers()
    }

    fun addObservers(){
        viewModel.technologies.observe(
            viewLifecycleOwner,
            Observer<List<Technology>> { technologies ->
                showTechnologies(technologies)
            })
    }

    private fun removeObservers() {
        viewModel.technologies.removeObservers(viewLifecycleOwner)
    }

    private fun showTechnologies(technologies: List<Technology>){
        //Toast.makeText(activity, "technologies: ${technologies.toString()}", Toast.LENGTH_LONG).show()

        val adapter = TechnologyItemAdapter(technologies)
        binding.rvTechnologies.adapter = adapter
        adapter.notifyDataSetChanged()
/*
        val divider = DividerItemDecoration(
            context,
            LinearLayoutManager.VERTICAL
        )*/

        //divider.
        //divider.setDrawable(ContextCompat.getDrawable(requireContext(), d.)!!)

        //binding.rvTechnologies.addItemDecoration(divider)

    }
}