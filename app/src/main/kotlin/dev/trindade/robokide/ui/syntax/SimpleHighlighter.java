package dev.trindade.robokide.ui.syntax;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Matcher;

public class SimpleHighlighter {
    
    private final List<SyntaxScheme> syntaxList;
    private final EditText mEditor;
    private final TextView mTextView;
    
    private String type;

    public SimpleHighlighter(EditText editor, String syntaxType) {
        this.mEditor = editor;
        this.mTextView = null;
        this.syntaxList = getSyntaxList(syntaxType);
        init();
    }

    public SimpleHighlighter(TextView textView, String syntaxType) {
        this.mTextView = textView;
        this.mEditor = null;
        this.syntaxList = getSyntaxList(syntaxType);
        init();
    }

    


    private List<SyntaxScheme> getSyntaxList(String syntaxType) {
        switch (syntaxType.toLowerCase()) {
            case "xml":
                return SyntaxScheme.XML();
            case "java":
                return SyntaxScheme.JAVA();
            default:
                throw new IllegalArgumentException("Unsupported syntax type");
        }
    }


    private void init() {
        if (mEditor != null) {
            mEditor.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    removeSpans(s, ForegroundColorSpan.class);
                    createHighlightSpans(syntaxList, s);
                }
            });
            removeSpans(mEditor.getText(), ForegroundColorSpan.class);
            createHighlightSpans(syntaxList, mEditor.getText());
        } else if (mTextView != null) {
            CharSequence text = mTextView.getText();
            if (text instanceof Editable) {
                Editable editable = (Editable) text;
                removeSpans(editable, ForegroundColorSpan.class);
                createHighlightSpans(syntaxList, editable);
            } else {
                SpannableStringBuilder builder = new SpannableStringBuilder(text);
                removeSpans(builder, ForegroundColorSpan.class);
                createHighlightSpans(syntaxList, builder);
                mTextView.setText(builder);
            }
        }
    }

    private void createHighlightSpans(List<SyntaxScheme> syntaxList, Editable editable) {
        for (SyntaxScheme scheme : syntaxList) {
            for (Matcher m = scheme.pattern.matcher(editable); m.find(); ) {
                if (scheme == scheme.getPrimarySyntax()) {
                    editable.setSpan(new ForegroundColorSpan(scheme.color), m.start(), m.end() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    editable.setSpan(new ForegroundColorSpan(scheme.color), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
    }

    private void removeSpans(Editable editable, Class<? extends CharacterStyle> type) {
        CharacterStyle[] spans = editable.getSpans(0, editable.length(), type);
        for (CharacterStyle span : spans) {
            editable.removeSpan(span);
        }
    }

    private void removeSpans(Spannable spannable, Class<? extends CharacterStyle> type) {
        CharacterStyle[] spans = spannable.getSpans(0, spannable.length(), type);
        for (CharacterStyle span : spans) {
            spannable.removeSpan(span);
        }
    }
}
