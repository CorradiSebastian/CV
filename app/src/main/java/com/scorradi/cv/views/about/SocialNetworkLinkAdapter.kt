package com.scorradi.cv.views.about

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.*
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.scorradi.cv.CvApplication
import com.scorradi.cv.databinding.SocialNetworkItemRowBinding
import com.scorradi.cv.views.models.SocialNetworkLinkModel


class SocialNetworkLinkAdapter(private val links: List<SocialNetworkLinkModel>) :
    RecyclerView.Adapter<SocialNetworkLinkAdapter.LinkItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkItemHolder {
        val binding =
            SocialNetworkItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LinkItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return links.size;
    }

    override fun onBindViewHolder(holder: LinkItemHolder, position: Int) {
        val link = links[position]
        holder.setLinkData(link)
    }

    class LinkItemHolder(
        val binding: SocialNetworkItemRowBinding,
        //private val onItemClick: OnClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var link: SocialNetworkLinkModel

        fun setLinkData(link: SocialNetworkLinkModel) {
            this.link = link
            binding.tvSocialNetworkName.text = link.name
            binding.tvSocialNetworkLink.text = link.link

            binding.btnCopyLink.setOnClickListener(){
                val clipboardManager = CvApplication.applicationContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("link", link.link)
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(CvApplication.applicationContext(), "Link copied", Toast.LENGTH_LONG).show()
            }
        }

    }

}
