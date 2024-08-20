package org.gampiot.robok.feature.terminal;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import com.termux.terminal.TerminalEmulator;
import com.termux.terminal.TerminalSession;
import com.termux.terminal.TerminalSessionClient;
import com.termux.view.TerminalViewClient;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.gampiot.robok.feature.terminal.databinding.ActivityTerminalBinding;
import org.gampiot.robok.feature.terminal.databinding.LayoutDialogInputBinding;
import org.gampiot.robok.feature.util.KeyboardUtil;
import org.gampiot.robok.feature.util.base.RobokActivity;

public class TerminalActivity extends RobokActivity implements TerminalSessionClient, TerminalViewClient {

     private ActivityTerminalBinding binding;
     private String cwd;
     private TerminalSession session;
     
     /* TO-DO: logic to save necessary terminal files in this dir */
     public static final String APP_HOME_DATA_DIR = "/data/data/org.gampiot.robok/files/home";
     
     public TerminalActivity () {
          super(0);
     }
     
     public TerminalActivity (@IdRes int fragmentLayoutResId) {
          super(fragmentLayoutResId);
     }
          
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = ActivityTerminalBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());
          if (getIntent().hasExtra("path")) {
              cwd = getIntent().getStringExtra("path");
          } else {
              cwd = Environment.getExternalStorageDirectory().getAbsolutePath();
          }
          binding.terminalView.setTextSize(28);
          String[] env = {};
          String[] argsList = {};
          session = new TerminalSession(
                APP_HOME_DATA_DIR,
                cwd,
                env,
                argsList,
                TerminalEmulator.DEFAULT_TERMINAL_CURSOR_STYLE,
          this);
          binding.terminalView.attachSession(session);
          binding.terminalView.setTerminalViewClient(this);
          configureFabs();
     }
     
     public void configureFabs() {
          setOptionsVisibility(true);
          binding.terminalOptionsButton.setOnClickListener(view -> setOptionsVisibility(false));
          binding.closeButton.setOnClickListener(view -> setOptionsVisibility(true));
          binding.installPackageButton.setOnClickListener(v -> {
               showInstallPackageDialog();
               setOptionsVisibility(true);
          });
          binding.updatePackagesButton.setOnClickListener(v -> {
               showUpdatePackagesDialog();
               setOptionsVisibility(true);
          });
     }
     
     public void setOptionsVisibility(boolean isHide) {
          binding.terminalOptionsLayout.animate()
                  .translationY(isHide ? 300 : 0)
                  .alpha(isHide ? 0 : 1)
                  .setInterpolator(new OvershootInterpolator());
                  
          binding.terminalOptionsButton.animate()
                  .translationY(isHide ? 0 : 300)
                  .alpha(isHide ? 1 : 0)
                  .setInterpolator(new OvershootInterpolator());
     }
     
     public void showInstallPackageDialog () {
          LayoutDialogInputBinding dialogBinding = LayoutDialogInputBinding.inflate(getLayoutInflater());
          var textField = dialogBinding.dialogEdittext;
          textField.setHint(getString(org.gampiot.robok.feature.res.R.string.terminal_install_package_hint));
          textField.setCornerRadius(15f);
          
          var dialog = new MaterialAlertDialogBuilder(this)
                 .setView(dialogBinding.getRoot())
                 .setTitle(getString(org.gampiot.robok.feature.res.R.string.terminal_install_package))
                 .setMessage(getString(org.gampiot.robok.feature.res.R.string.terminal_install_package_hint))
                 .setPositiveButton("Install", null)
                 .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss())
                 .create();
                 
          dialog.setOnShowListener(dialogInterface -> {
               Button positiveButton = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_POSITIVE);
               positiveButton.setOnClickListener(view -> {
                     String packageName = textField.getText().toString().trim();
                     if (packageName.isEmpty()) {
                          Toast.makeText(this, getString(org.gampiot.robok.feature.res.R.string.error_invalid_name), 4000).show();
                     } else {
                          installPackage(packageName);
                     }
                     dialogInterface.dismiss();
               });
          });
          dialog.setView(dialogBinding.getRoot());
          dialog.show();
          dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
          textField.requestFocus();
     }
     
     public void showUpdatePackagesDialog() {
          var dialog = new MaterialAlertDialogBuilder(this)
                 .setTitle(getString(org.gampiot.robok.feature.res.R.string.terminal_update_packages))
                 .setMessage(getString(org.gampiot.robok.feature.res.R.string.terminal_warning_update_packages))
                 .setPositiveButton("Update", (dialogInterface, i) -> {
                        // TO-DO: logic to update packages
                 })
                 .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss())
                 .create();
          dialog.show();       
     }
     
     public void installPackage(String packageName) {
          // TO-DO : logic to install package 
     }
     
     @Override
     protected void onDestroy() {
         super.onDestroy();
         binding = null;
     }
     
     @Override
     public float onScale(float scale) {
          return 1F;
     }
    
     @Override
     public void onSingleTapUp(MotionEvent e) {
         var kUtil = new KeyboardUtil();
         kUtil.showSoftInput(binding.terminalView);
     }
     
     @Override
     public boolean shouldBackButtonBeMappedToEscape() {
          return false;
     }
     
     @Override
     public boolean shouldEnforceCharBasedInput() {
          return false;
     }
     
     @Override
     public boolean shouldUseCtrlSpaceWorkaround() {
          return false;
     }
     
     @Override
     public boolean isTerminalViewSelected () {
          return false;
     }
     
     @Override
     public void copyModeChanged(boolean copyMode) {}
     
     @Override
     public boolean onKeyDown(int keyCode, KeyEvent e, TerminalSession session) {
          if (!session.isRunning()) {
              if (e.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                   finish();
              }
          }
          return false;
     }
     
     @Override
     public boolean onLongPress(MotionEvent event) {
          return true;
     }
     
     @Override
     public boolean readControlKey() {
          return false;
     }
     
     @Override
     public boolean readAltKey() {
          return false;
     }
     
     @Override 
     public boolean readFnKey() {
          return false;
     }
     
     @Override
     public boolean readShiftKey() {
          return false;
     }

     @Override
     public boolean onCodePoint(int codePoint, boolean ctrlDown, TerminalSession session) {
          return false;
     }
     
     @Override
     public void onEmulatorSet() {}
     
     @Override
     public void logError(String tag, String message) {}
     
     @Override
     public void logWarn(String tag, String message) {}
     
     @Override
     public void logInfo(String tag, String message) {}
     
     @Override
     public void logDebug(String tag, String message) {}
     
     @Override
     public void logVerbose(String tag, String message) {}
     
     @Override
     public void logStackTraceWithMessage(String tag, String message, Exception e) {}
     
     @Override
     public void logStackTrace(String tag, Exception e) {}
     
     @Override
     public void onTextChanged(@NonNull TerminalSession changedSession) {
          binding.terminalView.onScreenUpdated();
     }
     
     @Override
     public void onTitleChanged(@NonNull TerminalSession changedSession) {}
     
     @Override
     public void onSessionFinished(@NonNull TerminalSession finishedSession) {}
     
     @Override
     public void onBell(@NonNull TerminalSession session) {}
     
     @Override
     public void onColorsChanged(@NonNull TerminalSession session) {}
     
     @Override
     public void onTerminalCursorStateChange(boolean state) {}
     
     @Override
     public Integer getTerminalCursorStyle() {
          return TerminalEmulator.DEFAULT_TERMINAL_CURSOR_STYLE;
     }
     
     @Override
     public void onCopyTextToClipboard(@NonNull TerminalSession arg0, String arg1) {}
     
     @Override 
     public void onPasteTextFromClipboard(@Nullable TerminalSession session) {
     
     }
     @Override
     @MainThread
     public void onBackPressed() {
          if (!session.isRunning()) {
              super.onBackPressed();
          }
     }
}
