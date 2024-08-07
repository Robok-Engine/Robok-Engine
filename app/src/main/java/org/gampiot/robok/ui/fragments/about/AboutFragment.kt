package org.gampiot.robok.ui.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentAboutBinding
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.ui.fragments.about.model.TeamMember
import org.gampiot.robok.ui.fragments.about.adapter.TeamMemberAdapter

class AboutFragment(private val tansitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(tansitionAxis) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        setFragmentLayoutResId(R.id.fragment_container)
        val teamMembers = listOf(
            TeamMember(
                "https://avatars.githubusercontent.com/u/147993300?s=400&u=07c34e0c463a0236d09be78f2df121206edb583d&v=4",
                "Aquiles Trindade",
                "IDE Main Dev", 
                "https://github.com/aquilesTrindade"
            ),
            TeamMember(
                "https://avatars.githubusercontent.com/u/174269512?v=4", 
                "Th Dev", 
                "Language Main Dev", 
                "https://github.com/ThDev-only"
            ),
        )

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TeamMemberAdapter(teamMembers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}