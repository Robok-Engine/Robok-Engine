package robok.compiler.logic

interface LogicCompilerListener {
     fun onCompiling(log: String);
     fun onCompiled(output: String);
}