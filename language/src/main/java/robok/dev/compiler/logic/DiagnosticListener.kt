package robok.dev.compiler.logic

interface DiagnosticListener {
     fun onDiagnosticReveived(diagnostic: String)
}