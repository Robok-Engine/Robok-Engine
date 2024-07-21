package robok.diagnostic.logic

import kotlinx.coroutines.*

class DiagnosticHandler(private val diagnosticListener: DiagnosticListener) {

    private var diagnosticJob: Job? = null

    fun init() {
        startCheck()
    }

    private fun startCheck() {
        diagnosticJob?.cancel()
        diagnosticJob = CoroutineScope(Dispatchers.Main).launch {
            delay(5000L)
            diagnosticListener.onDiagnosticStatusReceive(false)
        }
    }

    fun onDiagnosticReceived(line: Int, positionStart: Int, positionEnd: Int, msg: String) {
        diagnosticJob?.cancel()
        diagnosticListener.onDiagnosticReceive(line, positionStart, positionEnd, msg)
    }
}