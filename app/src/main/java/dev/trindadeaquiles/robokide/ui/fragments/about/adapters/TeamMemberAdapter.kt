package dev.trindadeaquiles.robokide.ui.fragments.about.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import dev.trindadeaquiles.robokide.databinding.ItemTeamMemberBinding
import dev.trindadeaquiles.robokide.models.about.TeamMember

class TeamMemberAdapter(private val teamMembers: List<TeamMember>) :
    RecyclerView.Adapter<TeamMemberAdapter.TeamMemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val binding = ItemTeamMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        holder.bind(teamMembers[position])
    }

    override fun getItemCount(): Int = teamMembers.size

    inner class TeamMemberViewHolder(private val binding: ItemTeamMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(teamMember: TeamMember) {
            binding.nameTextView.text = teamMember.name
            binding.descriptionTextView.text = teamMember.description
            Glide.with(binding.profileImageView.context)
                .load(teamMember.profileIcon)
                .into(binding.profileImageView)
        }
    }
}