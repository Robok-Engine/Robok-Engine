package dev.trindade.robokide.ui.editor

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun HighlightingEditor(syntaxType: String) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    AndroidView(factory = { ctx ->
        EditText(ctx).apply {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    text = s.toString()
                }
            })
            SimpleHighlighter(this, syntaxType)
        }
    }, update = {
        it.setText(text)
    })
}