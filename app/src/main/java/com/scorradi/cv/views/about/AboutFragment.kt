package com.scorradi.cv.views.about

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.scorradi.cv.CvApplication
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

        binding.btnCopyEmail.setOnClickListener(){
            val clipboardManager = CvApplication.applicationContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("email", binding.tvEmail.text)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(CvApplication.applicationContext(), "Link copied", Toast.LENGTH_LONG).show()
        }
    }

    private fun addObservers() {
        viewModel.person.observe(viewLifecycleOwner, {
            showData(it)
        })
    }

    private fun showData(personModel: PersonModel){

        val adapter = SocialNetworkLinkAdapter(personModel.socialNetworkLinks)
        binding.rvSocialNetworks.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}