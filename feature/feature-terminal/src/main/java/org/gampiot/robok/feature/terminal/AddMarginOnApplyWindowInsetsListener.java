package org.gampiot.robok.feature.terminal;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/*
  See original file on :
      https://github.com/Sketchware-Pro/Sketchware-Pro/tree/main/app/src/main/java/mod/jbk/util/AddMarginOnApplyWindowInsetsListener.java
*/      
      
public class AddMarginOnApplyWindowInsetsListener implements OnApplyWindowInsetsListener {
    private final int insetsTypeMask;
    private final WindowInsetsCompat returnValue;

    public AddMarginOnApplyWindowInsetsListener(int insetsTypeMask, WindowInsetsCompat returnValue) {
        this.insetsTypeMask = insetsTypeMask;
        this.returnValue = returnValue;
    }

    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(@NonNull View v, @NonNull WindowInsetsCompat insets) {
        var toApply = insets.getInsets(insetsTypeMask);
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams layoutParams) {
            layoutParams.leftMargin += toApply.left;
            layoutParams.topMargin += toApply.top;
            layoutParams.rightMargin += toApply.right;
            layoutParams.bottomMargin += toApply.bottom;
        } else {
            throw new IllegalArgumentException("View's layout params must extend ViewGroup.MarginLayoutParams");
        }
        return returnValue;
    }
}
