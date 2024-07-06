package dev.trindade.robokide.ui.editor

import android.widget.EditText
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun HighlightingEditor(
    value: String,
    onValueChange: (String) -> Unit,
    syntaxType: String
) {
    val context = LocalContext.current

    AndroidView(factory = { ctx ->
        EditText(ctx).apply {
            setText(value)
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    s?.let {
                        onValueChange(it.toString())
                    }
                }
            })
            SimpleHighlighter(this, syntaxType)
        }
    }, update = {
        if (it.text.toString() != value) {
            it.setText(value)
        }
    })
}