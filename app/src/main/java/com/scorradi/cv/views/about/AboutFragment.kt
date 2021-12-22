package com.scorradi.cv.views.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.scorradi.cv.databinding.FragmentAboutBinding
import com.scorradi.cv.databinding.FragmentProfessionalDevelopmentBinding

class AboutFragment : Fragment() {
    private val binding get() = _binding
    private lateinit var _binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAboutBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

/*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        lifecycle.addObserver(viewModel)
    }*/
}