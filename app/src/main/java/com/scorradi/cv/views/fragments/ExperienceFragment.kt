package com.scorradi.cv.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.scorradi.cv.views.models.ExperienceModel

class ExperienceFragment() : Fragment() {
    companion object {

        // Method for creating new instances of the fragment
        fun newInstance(experienceModel: ExperienceModel): ExperienceFragment {

            // Store the movie data in a Bundle object
            val args = Bundle()
            //args.putSerializable()
            //TODO pasar los parametros
            args.putInt(ExperienceModel.KEY_EXPERIENCE_ID, experienceModel.experienceId)
            args.putString(ExperienceModel.KEY_COMPANY_NAME, experienceModel.companyName)
            args.putString(ExperienceModel.KEY_FROM, experienceModel.from.toString())
            args.putString(ExperienceModel.KEY_TO, experienceModel.to.toString())
            args.putString(ExperienceModel.ROLE, experienceModel.role)

            // Create a new MovieFragment and set the Bundle as the arguments
            // to be retrieved and displayed when the view is created
            val fragment = ExperienceFragment()
            fragment.arguments = args
            return fragment
        }
    }
}