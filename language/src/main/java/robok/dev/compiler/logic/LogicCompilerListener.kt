package robok.dev.compiler.logic

interface LogicCompilerListener {
     fun onCompiling(log: String);
     fun onCompiled(output: String);
}