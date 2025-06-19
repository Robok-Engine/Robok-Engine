package org.robok.engine.feature.editor.symbol;

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.util.AttributeSet;
import io.github.rosemoe.sora.widget.SymbolInputView;
import org.robok.engine.res.ResUtils;

@Deprecated
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

  void setColors() {
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
