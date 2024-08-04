package org.gampiot.robokide.feature.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.gampiot.robokide.feature.util.application.RobokApp;

public final class KeyboardUtils {

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void showSoftInput() {
        InputMethodManager imm =
            (InputMethodManager) RobokApp.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    public static void showSoftInput(@Nullable Activity activity) {
        if (activity != null && !isSoftInputVisible(activity)) {
            showSoftInput();
        }
    }

    public static void showSoftInput(@NonNull final View view) {
        showSoftInput(view, 0);
    }

    public static void showSoftInput(@NonNull final View view, final int flags) {
        InputMethodManager imm =
            (InputMethodManager) RobokApp.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            imm.showSoftInput(view, flags, new ResultReceiver(new Handler()) {
                @Override
                protected void onReceiveResult(int resultCode, Bundle resultData) {
                    if (resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN
                        || resultCode == InputMethodManager.RESULT_HIDDEN) {
                        showSoftInput(); 
                    }
                }
            });
        }
    }

    public static void hideSoftInput(@Nullable final Activity activity) {
        if (activity != null) {
            hideSoftInput(activity.getWindow());
        }
    }

    public static void hideSoftInput(@Nullable final Window window) {
        if (window != null) {
            View view = window.getCurrentFocus();
            if (view == null) {
                View decorView = window.getDecorView();
                View focusView = decorView.findViewWithTag("keyboardTagView");
                if (focusView == null) {
                    view = new EditText(window.getContext());
                    view.setTag("keyboardTagView");
                    ((ViewGroup) decorView).addView(view, 0, 0);
                } else {
                    view = focusView;
                }
                view.requestFocus();
            }
            hideSoftInput(view);
        }
    }

    public static void hideSoftInput(@NonNull final View view) {
        InputMethodManager imm =
            (InputMethodManager) RobokApp.getApp().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private static boolean isSoftInputVisible(@NonNull Activity activity) {
        return false;
    }
}