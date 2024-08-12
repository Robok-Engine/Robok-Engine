package org.gampiot.robok.ui.fragments.about.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import org.gampiot.robok.databinding.ItemContributorBinding
import org.gampiot.robok.ui.fragments.about.model.Contributor

class ContributorAdapter(private val teamMembers: List<Contributor>) :
    RecyclerView.Adapter<ContributorAdapter.ContributorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {
        val binding = ItemContributorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContributorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContributorViewHolder, position: Int) {
        holder.bind(teamMembers[position])
    }

    override fun getItemCount(): Int = teamMembers.size

    inner class ContributorViewHolder(private val binding: ItemContributorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(teamMember: Contributor) {
            binding.name.text = teamMember.login
            binding.role.text = teamMember.role
            Glide.with(binding.avatar.context)
                .load(teamMember.avatar_url)
                .into(binding.avatar)
            binding.container.setOnClickListener {
            
            }    
        }
    }
}
