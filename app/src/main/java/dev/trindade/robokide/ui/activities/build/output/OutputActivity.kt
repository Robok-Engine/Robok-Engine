package dev.trindade.robokide.ui.activities.build.output

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import dev.trindade.robokide.databinding.ActivityOutputBinding
import dev.trindade.robokide.R

class OutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}