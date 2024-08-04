package org.gampiot.robok.feature.terminal;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.termux.terminal.TerminalEmulator;
import com.termux.terminal.TerminalSession;
import com.termux.terminal.TerminalSessionClient;
import com.termux.view.TerminalViewClient;

import org.gampiot.robok.feature.terminal.databinding.ActivityTerminalBinding;
import org.gampiot.robok.feature.util.KeyboardUtils;
import org.gampiot.robok.feature.util.base.RobokActivity;

import java.util.ArrayList;
import java.util.List;

public class TerminalActivity extends RobokActivity implements TerminalSessionClient, TerminalViewClient {

    private ActivityTerminalBinding binding;
    private String cwd;
    private List<TerminalSession> sessions = new ArrayList<>();
    private TerminalSession currentSession;

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
        setupButtons();

        createNewSession();
        binding.terminalView.attachSession(currentSession);
        binding.terminalView.setTerminalViewClient(this);
    }

    private void setupButtons() {
        Button clearButton = new Button(this);
        clearButton.setText("Clear");
        clearButton.setOnClickListener(v -> currentSession.write("\033c"));
        binding.getRoot().addView(clearButton);
    }

    private void createNewSession() {
        currentSession = new TerminalSession(
                "/system/bin/sh",
                cwd,
                new String[]{},
                new String[]{},
                TerminalEmulator.DEFAULT_TERMINAL_CURSOR_STYLE,
                this
        );
        sessions.add(currentSession);
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
        KeyboardUtils.showSoftInput(binding.terminalView);
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
    public boolean isTerminalViewSelected() {
        return false;
    }

    @Override
    public void copyModeChanged(boolean copyMode) { }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent e, TerminalSession session) {
        if (!session.isRunning()) {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                finish();
            } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            
            }
        }
        return super.onKeyDown(keyCode, e);
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
    public void onEmulatorSet() { }

    @Override
    public void logError(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void logWarn(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void logInfo(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    public void logDebug(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    public void logVerbose(String tag, String message) {
        Log.v(tag, message);
    }

    @Override
    public void logStackTraceWithMessage(String tag, String message, Exception e) {
        Log.e(tag, message, e);
    }

    @Override
    public void logStackTrace(String tag, Exception e) {
        Log.e(tag, "", e);
    }

    @Override
    public void onTextChanged(@NonNull TerminalSession changedSession) {
        binding.terminalView.post(() -> binding.terminalView.onScreenUpdated());
    }

    @Override
    public void onTitleChanged(@NonNull TerminalSession changedSession) { }

    @Override
    public void onSessionFinished(@NonNull TerminalSession finishedSession) {
        sessions.remove(finishedSession);
        if (sessions.isEmpty()) {
            finish();
        }
    }

    @Override
    public void onBell(@NonNull TerminalSession session) { }

    @Override
    public void onColorsChanged(@NonNull TerminalSession session) { }

    @Override
    public void onTerminalCursorStateChange(boolean state) { }

    @Override
    public Integer getTerminalCursorStyle() {
        return TerminalEmulator.DEFAULT_TERMINAL_CURSOR_STYLE;
    }

    @Override
    public void onCopyTextToClipboard(@NonNull TerminalSession session, String text) { }

    @Override
    public void onPasteTextFromClipboard(@Nullable TerminalSession session) { }

    @Override
    @MainThread
    public void onBackPressed() {
        if (!currentSession.isRunning()) {
            super.onBackPressed();
        }
    }
}
