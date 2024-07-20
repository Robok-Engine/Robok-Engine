package robok.dev.opengl.GameTimer;

import android.os.SystemClock;

import robok.dev.opengl.GamePad.GameTimerUpdateCallback;

public class GameTimer {
    private int minute, second;

    private float startTime;

    private GameTimerUpdateCallback mGameTimerUpdateCallback;
    public GameTimer() {
        minute = 0;
        second = 0;
    }

    public void setTimerUpdateCallback(GameTimerUpdateCallback g) {
        mGameTimerUpdateCallback = g;
    }

    public String getTimeString() {
        String t = new String("Ticking- ");
        // Minute
        t = t + (minute<10? "0": "") + minute;
        t+= ":";
        // Second
        t = t + (second<10? "0": "") + second;
        return t;
    }

    public void startTimer() {
        startTime = SystemClock.uptimeMillis();
        mHandler.postDelayed(updateTimerThread, 0);
    }

    private android.os.Handler mHandler = new android.os.Handler();

    private Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            float currentTime = SystemClock.uptimeMillis() - startTime;
            second = (int) (currentTime / 1000);
            minute = second / 60;
            second = second % 60;
            mHandler.postDelayed(updateTimerThread, 0);
            mGameTimerUpdateCallback.onTimerUpdate();
        }
    };
}
