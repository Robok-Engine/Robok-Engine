package robok.diagnostic.logic

interface DiagnosticListener {
    fun onDiagnosticReceive(line: Int, positionStart: Int, positionEnd: Int, msg: String)
    fun onDiagnosticStatusReceive(isError: Boolean)
}
