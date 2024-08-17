package org.gampiot.robok.feature.theme;

import androidx.annotation.ColorRes;
import androidx.annotation.StyleRes;

import org.gampiot.robok.feature.theme.R;

public enum Theme {
     AMBER(R.style.Theme_Robok_Amber, R.color.amber_theme_primary),
     BLUE(R.style.Theme_Robok_Blue, R.color.blue_theme_primary),
     RED(R.style.Theme_Robok_Red, R.color.red_theme_primary),
     GREEN(R.style.Theme_Robok_Green, R.color.green_theme_primary),
     BLUEDARK(R.style.Theme_Robok_BlueDark, R.color.bluedark_theme_onPrimary),
     YELLODRAK(R.style.Theme_Robok_YellowDark, R.color.yellowdark_theme_primary),
     POPDRAK(R.style.Theme_Robok_DarkViolet, R.color.darkviolet_theme_primary),
     LIGHTBROWN(R.style.Theme_Robok_LightBrown, R.color.lightbrown_theme_primary);

     @StyleRes private final int themeId;

     @ColorRes private final int primaryColor;

     Theme(@StyleRes int themeId, @ColorRes int primaryColor) {
          this.themeId = themeId;
          this.primaryColor = primaryColor;
     }

     @StyleRes
     public int getThemeId() {
          return themeId;
     }

     @ColorRes
     public int getPrimaryColor() {
          return primaryColor;
     }
}
