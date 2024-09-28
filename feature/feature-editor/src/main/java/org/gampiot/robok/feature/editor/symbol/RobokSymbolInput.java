package org.gampiot.robok.feature.editor.symbol;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.content.Context;
import android.util.AttributeSet;

import io.github.rosemoe.sora.widget.SymbolInputView;

import org.gampiot.robok.strings.ResUtils;

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