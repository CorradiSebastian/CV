package com.scorradi.cv.views.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.scorradi.cv.databinding.FragmentAboutBinding
import com.scorradi.cv.databinding.FragmentProfessionalDevelopmentBinding
import com.scorradi.cv.views.components.TechnologyItemAdapter
import com.scorradi.cv.views.main.MainViewModel
import com.scorradi.cv.views.models.PersonModel

class AboutFragment : Fragment() {
    private val binding get() = _binding
    private lateinit var _binding: FragmentAboutBinding
    private val viewModel: AboutViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAboutBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        lifecycle.addObserver(viewModel)
    }

    private fun addObservers() {
        viewModel.person.observe(viewLifecycleOwner, {
            showData(it)
        })
    }

    private fun showData(personModel: PersonModel){
        _binding.tvLinkedin.text = personModel.socialNetworkLinks.get(0).link

        val adapter = SocialNetworkLinkAdapter(personModel.socialNetworkLinks)
        binding.rvSocialNetworks.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}