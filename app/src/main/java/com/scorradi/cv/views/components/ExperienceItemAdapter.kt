package com.scorradi.cv.views.components

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scorradi.cv.databinding.ExperienceItemRowBinding
import com.scorradi.cv.views.models.ExperienceModel

class ExperienceItemAdapter(private val experienceModels: List<ExperienceModel>) : RecyclerView.Adapter<ExperienceItemAdapter.ExperienceItemHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceItemHolder {
        val binding = ExperienceItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExperienceItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return experienceModels.size;
    }

    override fun onBindViewHolder(holder: ExperienceItemHolder, position: Int) {
        val experienceModel = experienceModels[position]
        holder.setExperienceModel(experienceModel)
    }

    class ExperienceItemHolder(val binding: ExperienceItemRowBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private var experienceModel:ExperienceModel? = null

        fun setExperienceModel(experienceModel: ExperienceModel){
            this.experienceModel = experienceModel
            binding.tvCompanyName.text = experienceModel.CompanyName
            binding.tvFrom.text = experienceModel.From.toString()
            binding.tvTo.text = experienceModel.To.toString()
        }
        //3
        init {
            binding.root.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

    }
}