package robok.dev.diagnostic.logic

interface DiagnosticListener {
     fun onDiagnosticReceive (status: Boolean, diagnostic: String)
}