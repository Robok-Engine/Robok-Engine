package org.gampiot.robok.feature.component.textfield;

import android.content.Context;
import android.util.AttributeSet;

import dev.trindadedev.lib.ui.components.textfield.TInput;

public class NormalTextField extends TInput {

    public NormalTextField(Context context) {
         super(context);
    }

    public NormalTextField(Context context, AttributeSet attrs) {
         super(context, attrs);
    }

    public NormalTextField(Context context, AttributeSet attrs, int defStyleAttr) {
         super(context, attrs, defStyleAttr);
    }

    void setCornerRadius (float radii) {
        textInputLayout.setBoxCornerRadii(radii, radii, radii, radii);
    }
}
