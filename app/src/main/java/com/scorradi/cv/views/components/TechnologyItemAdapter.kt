package com.scorradi.cv.views.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scorradi.cv.databinding.ExperienceItemRowBinding
import com.scorradi.cv.databinding.TechnologyItemRowBinding
import com.scorradi.cv.db.daos.entities.Technology
import com.scorradi.cv.views.models.ExperienceModel

class TechnologyItemAdapter(private val technologies: List<Technology>) :
    RecyclerView.Adapter<TechnologyItemAdapter.TechnologyItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechnologyItemHolder {
        val binding =
            TechnologyItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TechnologyItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return technologies.size;
    }

    override fun onBindViewHolder(holder: TechnologyItemHolder, position: Int) {
        val technology = technologies[position]
        holder.setTechnology(technology)
    }

    class TechnologyItemHolder(
        val binding: TechnologyItemRowBinding,
        //private val onItemClick: OnClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var technology: Technology

        fun setTechnology(technology: Technology) {
            this.technology = technology
            binding.tvName.text = technology.name
            binding.tvDescription.text = technology.description
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
