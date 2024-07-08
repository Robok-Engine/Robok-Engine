package dev.trindade.robokide.ui.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.trindade.robokide.databinding.ActivityMainBinding
import dev.trindade.robokide.R
import dev.trindade.robokide.ui.terminal.RobokTerminal
import robok.dev.compiler.logic.LogicCompiler
import robok.dev.compiler.logic.LogicCompilerListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var myLogs = "hello"
        
        val terminal = RobokTerminal(this)
        val compilerListener = object : LogicCompilerListener {
            override fun onCompiled(logs: String) {
                myLogs = logs
                showTerminal(terminal, myLogs)
            }
        }
        
        val compiler = LogicCompiler(this, compilerListener)
        
        binding.runButton.setOnClickListener {
            val code = binding.codeEditor.text.toString()
            compiler.compile(code)
        }
        
        binding.seeLogs.setOnClickListener {
            showTerminal(terminal, null)
        }
    }
    
    private fun showTerminal(terminal: RobokTerminal, logs: String?) {
        logs?.let {
            terminal.addLog(it)
        }
        terminal.show()
    }
}