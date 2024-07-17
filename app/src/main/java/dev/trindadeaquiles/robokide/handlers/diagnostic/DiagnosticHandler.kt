package dev.trindadeaquiles.robokide.handlers.diagnostic

/*
   Handler to check whether it has a diagnostic or not.
*/

class DiagnosticHandler  {

    interface DiagnosticListener {
        fun onDiagnosticStatusReceive(status: Boolean)
    }
}