package org.gampiot.robok.ui.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentAboutBinding
import org.gampiot.robok.ui.fragments.about.adapter.ContributorAdapter
import org.gampiot.robok.ui.fragments.about.viewmodel.ContributorViewModel
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.component.terminal.RobokTerminal

class AboutFragment(private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContributorViewModel by viewModels()

    private lateinit var terminal: RobokTerminal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        
        terminal = RobokTerminal(requireContext())
        terminal.show()
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        setFragmentLayoutResId(R.id.fragment_container)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.contributors.observe(viewLifecycleOwner) { contributors ->
            binding.recyclerView.adapter = ContributorAdapter(contributors)
            terminal.addLog("Contributors loaded: ${contributors.size}")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
