package dev.trindade.robokide.ui.activities.main

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import dev.trindade.robokide.databinding.ActivityMainBinding

import dev.trindade.robokide.R
import dev.trindade.robokide.terminal.RobokTerminal
import robok.trindade.compiler.RobokCompiler

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val terminal = RobokTerminal(this)
        val compilerListener = object : RobokCompiler.CompilerListener {
            override fun onCompiled(logs: String) {
                terminal.show()
            }
        }
        val compiler = RobokCompiler(this, compilerListener)
        
        binding.runButton.setOnClickListener {
            val code = binding.codeEditor.text.toString()
            compiler.compile(code)
        }
    }
}