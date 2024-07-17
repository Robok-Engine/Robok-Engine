package robok.dev.diagnostic.logic

interface DiagnosticListener {
    fun onDiagnosticReceive(line: Int, positionStart: Int, positionEnd: Int, msg: String) {
        onDiagnosticStatusReceive(true)
    }
    fun onDiagnosticStatusReceive(isError: Boolean)
}