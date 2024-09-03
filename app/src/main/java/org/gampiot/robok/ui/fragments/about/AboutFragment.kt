package org.gampiot.robok.ui.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.annotation.IdRes 

import com.google.android.material.transition.MaterialSharedAxis

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import okhttp3.OkHttpClient
import okhttp3.Request

import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.aboutlibraries.*

import org.gampiot.robok.R
import org.gampiot.robok.BuildConfig
import org.gampiot.robok.databinding.FragmentAboutBinding
import org.gampiot.robok.ui.fragments.about.adapter.ContributorAdapter
import org.gampiot.robok.ui.fragments.about.model.Contributor
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.component.terminal.RobokTerminal

class AboutFragment() : RobokFragment() {

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        
        binding.contributorsRecyclerView.layoutManager = LinearLayoutManager(context)

        fetchContributors()
        configureSocialLinks()
    }

    fun fetchContributors() {
        CoroutineScope(Dispatchers.IO).launch {
            val request = Request.Builder()
                .url(getString(Strings.link_contributors))
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
                                binding.contributorsRecyclerView.adapter = ContributorAdapter(usersList)
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
    
    fun configureSocialLinks () {
        binding.openTelegram.setOnClickListener {
            openUrl(getString(Strings.link_telegram))
        }
        
        binding.openGithub.setOnClickListener {
            openUrl(getString(Strings.link_github))
        }
        
        binding.openGithub.setOnLongClickListener {
            terminal.show()
            return true
        }
        
        binding.openContribute.setOnClickListener {
            openUrl(getString(Strings.link_github))
        }
    }
    
    fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
