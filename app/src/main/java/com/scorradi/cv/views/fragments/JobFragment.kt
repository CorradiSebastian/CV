package com.scorradi.cv.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.scorradi.cv.R
import com.scorradi.cv.databinding.JobDialogBinding
import com.scorradi.cv.views.models.JobModel

class JobFragment : DialogFragment() {


    companion object {
        val KEY_JOB_MODEL: String = "JOB_MODEL"
        val TAG: String = "JobFragment"

        fun newInstance(jobModel: JobModel): JobFragment {

            val args = Bundle()
            args.putSerializable(KEY_JOB_MODEL, jobModel)

            val fragment = JobFragment()
            fragment.arguments = args

            return fragment
        }
    }

    private lateinit var binding: JobDialogBinding;


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.rounded_corner);
        binding = JobDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jobModel = arguments?.getSerializable(KEY_JOB_MODEL) as JobModel

        binding.tvJobName.text = jobModel.name
        binding.tvCompanyName.text = jobModel.companyName
        binding.tvResponsibilities.text = jobModel.responsibilities
        //TODO just in case to show the other data
//        binding.tvTechnologies.text = jobModel.technologies
//        binding.tvLibraries.text = jobModel.libraries
//        binding.tvExtras.text = jobModel.extras

    }

}