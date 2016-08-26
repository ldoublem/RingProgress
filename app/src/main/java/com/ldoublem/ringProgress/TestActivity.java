package com.ldoublem.ringProgress;

import android.content.Intent;
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


public class TestActivity extends AppCompatActivity {


    RingProgress mRingProgress;
    SeekBar mSeekBar;
    SeekBar mSeekBar2;
    SeekBar mSeekBar3;
    CheckBox mCheckBox;
    CheckBox mCheckBox2;
    CheckBox mCheckBox3;


    Random random = new Random();
    List<Ring> mlistRing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.layout_test);

        getSupportActionBar().hide();

        mRingProgress = (RingProgress) findViewById(R.id.lv_ringp);
        mRingProgress.setOnSelectRing(new OnSelectRing() {
            @Override
            public void Selected(Ring r) {
                Toast.makeText(TestActivity.this, r.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        mSeekBar = (SeekBar) findViewById(R.id.sb_with);
        mSeekBar2 = (SeekBar) findViewById(R.id.sb_rotate);
        mSeekBar3 = (SeekBar) findViewById(R.id.sb_sweepAngle);
        mCheckBox = (CheckBox) findViewById(R.id.cb_background);
        mCheckBox2 = (CheckBox) findViewById(R.id.cb_corner);
        mCheckBox3 = (CheckBox) findViewById(R.id.cb_shadow);
        setData();
        mSeekBar.setProgress((int) (mRingProgress.getRingWidthScale() * 100));
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRingProgress.setRingWidthScale(i / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSeekBar2.setProgress((int) (mRingProgress.getRotateAngle() / 360f * 100f));
        mSeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRingProgress.setRotateAngle((int) (360f * (i / 100f)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSeekBar3.setProgress((int) (mRingProgress.getSweepAngle() / 360f * 100f));


        mSeekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRingProgress.setSweepAngle((int) (360f * (i / 100f)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mCheckBox.setChecked(mRingProgress.isDrawBg());
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mRingProgress.setDrawBg(b, Color.rgb(168, 168, 168));
//                mRingProgress.setDrawBg(b);

            }
        });


        mCheckBox2.setChecked(mRingProgress.isCorner());
        mCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mRingProgress.setCorner(b);

            }
        });

        mCheckBox3.setChecked(mRingProgress.isDrawBgShadow());
        mCheckBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mRingProgress.setDrawBgShadow(b, Color.argb(100, 235, 79, 56));
//                mRingProgress.setDrawBgShadow(b);
            }
        });

    }


    private String[] data = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};


    private void setData() {
        mlistRing.clear();
        for (int i = 0; i < data.length; i++) {

            Ring r = new Ring();
            int p = random.nextInt(100);
            r.setProgress(p);
            r.setValue(String.valueOf(p * 100));

            r.setName(data[i]);


            if (i == 0) {

                r.setStartColor(Color.rgb(235, 79, 56));
                r.setEndColor(Color.argb(100, 235, 79, 56));


            }
            if (i == 1) {
                r.setStartColor(Color.rgb(17, 205, 110));
                r.setEndColor(Color.argb(100, 17, 205, 110));

            }
            if (i == 2) {
                r.setStartColor(Color.rgb(234, 128, 16));
                r.setEndColor(Color.argb(100, 234, 128, 16));

            }
            if (i == 3) {
                r.setStartColor(Color.rgb(86, 171, 228));
                r.setEndColor(Color.argb(100, 86, 171, 228));

            }
            if (i == 4) {
                r.setStartColor(Color.rgb(157, 85, 184));
                r.setEndColor(Color.argb(100, 157, 85, 184));

            }


            mlistRing.add(r);

        }
        mRingProgress.setData(mlistRing, 500);

    }


    public void automatic(View v) {
        setData();


    }

    public void countdown(View v) {
        Intent i = new Intent();
        i.setClass(this, Test2Activity.class);
        startActivity(i);

    }


}
