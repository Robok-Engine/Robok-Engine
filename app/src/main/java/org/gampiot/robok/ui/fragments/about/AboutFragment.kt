package org.gampiot.robok.ui.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.material.transition.MaterialSharedAxis

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import okhttp3.OkHttpClient
import okhttp3.Request

import org.gampiot.robok.R
import org.gampiot.robok.BuildConfig
import org.gampiot.robok.databinding.FragmentAboutBinding
import org.gampiot.robok.ui.fragments.about.adapter.ContributorAdapter
import org.gampiot.robok.ui.fragments.about.model.Contributor
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.component.terminal.RobokTerminal
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.aboutlibraries.*
class AboutFragment(private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    private lateinit var terminal: RobokTerminal
    private val client = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        terminal = RobokTerminal(requireContext())
        binding.showLogs.setOnClickListener {
             terminal.show()
        }
        binding.libv.setOnClickListener{
        LibsBuilder()
    .start(this) 
        }
        if (!BuildConfig.DEBUG) {
            binding.showLogs.visibility = View.GONE
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        setFragmentLayoutResId(R.id.fragment_container)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        fetchContributors()
    }

    private fun fetchContributors() {
        CoroutineScope(Dispatchers.IO).launch {
            val request = Request.Builder()
                .url("https://raw.githubusercontent.com/robok-inc/Robok-Engine/dev/contributors/contributors_github.json")
                .build()

            try {
                client.newCall(request).execute().use { response ->
                    if (response.isSuccessful) {
                        val jsonString = response.body?.string()
                        terminal.addLog("Response successful: $jsonString")
                        jsonString?.let {
                            val contributorsList = Json.decodeFromString<List<Contributor>>(it)
                            
                            val usersList = contributorsList.filter { it.type == "User" }

                            launch(Dispatchers.Main) {
                                binding.recyclerView.adapter = ContributorAdapter(usersList)
                                terminal.addLog("Parsed users: ${usersList.size}")
                            }
                        }
                    } else {
                        terminal.addLog("Request failed with code: ${response.code}")
                    }
                }
            } catch (e: Exception) {
                terminal.addLog("Network request failed: ${e.message}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
