package org.gampiot.robok.feature.editor.symbol;

import android.content.Context;
import android.util.AttributeSet;

import io.github.rosemoe.sora.widget.SymbolInputView;

import org.gampiot.robok.feature.res.ResUtils;

public class RobokSymbolInput extends SymbolInputView {

     public Context context;

     public RobokSymbolInput(Context context) {
          super(context);
          this.context = context;
          setColors();
     }

     public RobokSymbolInput(Context context, AttributeSet attrs) {
          super(context, attrs);
          this.context = context;
          setColors();
    }

    public RobokSymbolInput(Context context, AttributeSet attrs, int defStyleAttr) {
         super(context, attrs, defStyleAttr);
         this.context = context;
         setColors();
    }

    public RobokSymbolInput(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
         super(context, attrs, defStyleAttr, defStyleRes);
         this.context = context;
         setColors();
    }
    
    public final boolean usePrimaryColor = false;
    
    void setColors () {
         var resUtils = new ResUtils(context);
         var backgroundColor = resUtils.getAttrColor(android.R.attr.colorBackground);
         var symbolColor = 0;
         if (usePrimaryColor) {
              symbolColor = resUtils.getAttrColor(com.google.android.material.R.attr.colorPrimary);
         } else {
              symbolColor = resUtils.getAttrColor(com.google.android.material.R.attr.colorOnSurface);
         }
         setBackgroundColor(backgroundColor);
         setTextColor(symbolColor);
    }
}