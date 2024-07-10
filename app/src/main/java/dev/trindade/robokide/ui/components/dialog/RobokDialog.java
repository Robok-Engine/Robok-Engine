package dev.trindade.robokide.ui.components.dialog;

import static com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.TypedValue;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

import dev.trindade.robokide.R;

@SuppressLint("RestrictedApi")
public class RobokDialog extends MaterialAlertDialogBuilder {
  @AttrRes private static final int DEF_STYLE_ATTR = R.attr.RobokDialog;
  @StyleRes private static final int DEF_STYLE_RES = R.style.Dialog_Robok;

  @AttrRes
  private static final int DIALOG_THEME_OVERLAY = R.attr.ThemeOverlay_Robok_Dialog;

  private static int getDialogThemeOverlay(@NonNull Context context) {
    TypedValue dialogThemeOverlay = MaterialAttributes.resolve(context, DIALOG_THEME_OVERLAY);
    if (dialogThemeOverlay == null) {
      return 0;
    }
    return dialogThemeOverlay.data;
  }

  private static Context createDialogThemedContext(@NonNull Context context) {
    int themeOverlayId = getDialogThemeOverlay(context);
    Context themedContext = wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
    if (themeOverlayId == 0) {
      return themedContext;
    }
    return new ContextThemeWrapper(themedContext, themeOverlayId);
  }

  private static int getOverridingThemeResId(@NonNull Context context, int overrideThemeResId) {
    return overrideThemeResId == 0 ? getDialogThemeOverlay(context) : overrideThemeResId;
  }

  public RobokDialog(@NonNull Context context) {
    this(context, 0);
  }

  public RobokDialog(@NonNull Context context, int overrideThemeResId) {
    super(createDialogThemedContext(context), getOverridingThemeResId(context, overrideThemeResId));
    context = getContext();

    TypedArray a =
        context.obtainStyledAttributes(
            /* attrs= */ null, R.styleable.RobokDialog, DEF_STYLE_ATTR, DEF_STYLE_RES);
    int backgroundColor = a.getColor(R.styleable.RobokDialog_backgroundTint, 0);
    float strokeWidth = a.getDimension(R.styleable.RobokDialog_strokeWidth, 0);
    int strokeColor = a.getColor(R.styleable.RobokDialog_strokeColor, 0);
    a.recycle();

    MaterialShapeDrawable backgroundShape =
        new MaterialShapeDrawable(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
    backgroundShape.setFillColor(ColorStateList.valueOf(backgroundColor));
    backgroundShape.setStroke(strokeWidth, strokeColor);

    setBackground(backgroundShape);
  }
}
