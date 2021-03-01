package com.scorradi.cv.views.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scorradi.cv.databinding.ExperienceItemRowBinding
import com.scorradi.cv.views.models.ExperienceModel

class ExperienceItemAdapter(private val experienceModels: List<ExperienceModel>, private val onItemClick: OnClickListener) :
    RecyclerView.Adapter<ExperienceItemAdapter.ExperienceItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceItemHolder {
        val binding =
            ExperienceItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExperienceItemHolder(binding, onItemClick)
    }

    override fun getItemCount(): Int {
        return experienceModels.size;
    }

    override fun onBindViewHolder(holder: ExperienceItemHolder, position: Int) {
        val experienceModel = experienceModels[position]
        holder.setExperienceModel(experienceModel)
    }

    class ExperienceItemHolder(
        val binding: ExperienceItemRowBinding,
        private val onItemClick: OnClickListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var experienceModel: ExperienceModel

        fun setExperienceModel(experienceModel: ExperienceModel) {
            this.experienceModel = experienceModel
            binding.tvCompanyName.text = experienceModel.companyName
            binding.tvFrom.text = experienceModel.from.toString()
            binding.tvTo.text = experienceModel.to.toString()
        }

        //3
        init {
            binding.root.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            onItemClick.onClick(experienceModel);
        }

    }

    interface OnClickListener {
        /**
         * Called when a experienceModel has been clicked.
         *
         * @param experience The experienceModel that was clicked.
         */
        fun onClick(experienceModel: ExperienceModel)
    }
}