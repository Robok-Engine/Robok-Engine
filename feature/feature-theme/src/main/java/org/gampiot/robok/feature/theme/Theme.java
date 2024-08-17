package org.gampiot.robok.feature.theme;

import androidx.annotation.ColorRes;
import androidx.annotation.StyleRes;

import org.gampiot.robok.feature.theme.R;

public enum Theme {
     AMBER(R.style.Theme_Robok_Amber, R.color.md_amber_theme_primary),
     BLUE(R.style.Theme_Robok_Blue, R.color.md_blue_theme_primary),
     RED(R.style.Theme_Robok, R.color.md_theme_primary),
     GREEN(R.style.Theme_Robok_Green, R.color.md_green_theme_primary),
     BLUEDARK(R.style.Theme_Robok_BlueDark, R.color.md_bluedark_theme_onPrimary),
     YELLODRAK(R.style.Theme_Robok_YellowDark, R.color.md_yellowdark_theme_primary),
     POPDRAK(R.style.Theme_Robok_DarkViolet, R.color.md_darkviolet_theme_primary),
     LIGHTBROWN(R.style.Theme_Robok_LightBrown, R.color.md_lightbrown_theme_primary);

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
