package robok.dev.diagnostic.logic

interface DiagnosticListener {
     fun onDiagnosticReceive(line: Int, positionStart: Int, postionEnd: Int, msg: String);
}