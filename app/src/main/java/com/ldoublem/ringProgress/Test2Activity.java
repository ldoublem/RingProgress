package com.ldoublem.ringProgress;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.ldoublem.ringPregressLibrary.OnSelectRing;
import com.ldoublem.ringPregressLibrary.Ring;
import com.ldoublem.ringPregressLibrary.RingProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Test2Activity extends AppCompatActivity {


    RingProgress mRingProgress;
    int maxTime = 100;

    Random random = new Random();
    List<Ring> mlistRing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.layout_test2);
        getSupportActionBar().hide();

        mRingProgress = (RingProgress) findViewById(R.id.lv_ringp);
        mRingProgress.setDrawBg(false);
        setData(maxTime, maxTime + "'", "Countdown", Color.rgb(86, 171, 228), Color.argb(100, 86, 171, 228));


    }


    private void setData(int progress, String value, String title, int startColor,
                         int endColor) {
        mlistRing.clear();
        Ring r = new Ring(progress, value, title, startColor, endColor);
//        r.setProgress(progress);
//        r.setValue(text);
//        r.setName(title);
//        r.setStartColor(startColor);
//        r.setEndColor(endColor);
        mlistRing.add(r);
        mRingProgress.setData(mlistRing, 0);

    }


    public void start(View v) {
        mRingProgress.stopAnim();
        startProgressAnim();
    }

    public void stop(View v) {
        stopProgressAnim();
    }


    int mValueLVRingProgress = 0;
    public Timer mTimerLVRingProgress = new Timer();// 定时器

    public void timerTaskLVRingProgress() {
        mTimerLVRingProgress.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mValueLVRingProgress < maxTime) {

                    mValueLVRingProgress++;
                    Message msg = mHandle.obtainMessage(0);
                    msg.arg1 = mValueLVRingProgress;
                    mHandle.sendMessage(msg);

                } else {
                    Message msg = mHandle.obtainMessage(1);
                    mHandle.sendMessage(msg);
                    mTimerLVRingProgress.cancel();
                }
            }
        }, 0, 100);
    }


    private void startProgressAnim() {
        if (mValueLVRingProgress == 100)
            mValueLVRingProgress = 0;

        if (mTimerLVRingProgress != null) {
            mTimerLVRingProgress.cancel();
        }
        mTimerLVRingProgress = new Timer();
        timerTaskLVRingProgress();
    }

    private void stopProgressAnim() {
        if (mTimerLVRingProgress != null) {
            mTimerLVRingProgress.cancel();
            int p = maxTime - (int) (mValueLVRingProgress);
            setData(p, p + "'", "Pause", Color.rgb(234, 128, 16), Color.argb(100, 234, 128, 16));


        }
    }


    private Handler mHandle = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            mLVRingProgress.setProgress(msg.arg1);
            if (msg.what == 0) {
                int p = maxTime - (int) (msg.arg1);


                if (p > 60) {
                    setData(p, p + "'", "Countdown", Color.rgb(86, 171, 228), Color.argb(100, 86, 171, 228));

                } else if (p > 30) {
                    setData(p, p + "'", "Countdown", Color.rgb(17, 205, 110), Color.argb(100, 17, 205, 110));

                } else {
                    setData(p, p + "'", "Countdown", Color.rgb(235, 79, 56), Color.argb(100, 235, 79, 56));

                }
            } else {
                Toast.makeText(Test2Activity.this, "ok", Toast.LENGTH_SHORT).show();
                setData(maxTime, maxTime + "'", "Countdown", Color.rgb(86, 171, 228), Color.argb(100, 86, 171, 228));

            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimerLVRingProgress != null) {
            mTimerLVRingProgress.cancel();
        }
    }
}
