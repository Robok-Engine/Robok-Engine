package org.gampiot.robok.feature.component.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import dev.trindadedev.lib.ui.components.R;
import dev.trindadedev.lib.ui.components.dialog.PermissionDialog;

import org.gampiot.robok.feature.component.textfield.NormalTextField;

public class DialogEditText extends PermissionDialog {

    public NormalTextField tInput;
    public String textFieldHint;
    public String textFieldText;
    public float textFieldRadii;

    public DialogEditText(Context context, Builder builder) {
        super(context, builder);
        this.textFieldHint = builder.textFieldHint;
        this.textFieldText = builder.textFieldText;
        this.textFieldRadii = builder.textFieldRadii;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_edit_text);

        ImageView dialogIcon = findViewById(R.id.dialog_icon);
        TextView dialogText = findViewById(R.id.dialog_text);
        tInput = findViewById(R.id.dialog_textfield);
        Button buttonAllow = findViewById(R.id.button_allow);
        Button buttonDeny = findViewById(R.id.button_deny);

        dialogIcon.setImageResource(iconResId);
        dialogText.setText(Html.fromHtml(text));

        tInput.setHint(textFieldHint);
        tInput.setText(textFieldText);
        tInput.setCornerRadius(textFieldRadii); 

        buttonAllow.setOnClickListener(v -> {
            if (allowClickListener != null) {
                allowClickListener.onClick(v);
            }
            dismiss();
        });

        buttonDeny.setOnClickListener(v -> {
            if (denyClickListener != null) {
                denyClickListener.onClick(v);
            }
            dismiss();
        });

        if (getWindow() != null) {
            getWindow().getDecorView().setBackgroundColor(0);
        }
        setCancelable(false);
    }

    public static class Builder extends PermissionDialog.Builder {
    
        public String textFieldHint;
        public String textFieldText;
        public float textFieldRadii;

        public Builder(Context context) {
            super(context);
        }
        
        public Builder setTextFieldHint(String hint) {
            this.textFieldHint = hint; 
            return this;
        }
        
        public Builder setTextFieldText(String text) {
            this.textFieldText = text;
            return this;
        }
        
        public Builder setTextFieldCornerRadius(float radii) {
            this.textFieldRadii = radii;
            return this;
        }

        @Override
        public DialogEditText build() {
            return new DialogEditText(context, this);
        }
    }
}
