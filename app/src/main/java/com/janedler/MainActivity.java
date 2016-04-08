package com.janedler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar mBar1,mBar2,mBar3;
    private JCircleView mJCircleView;
    private float[] mPositions = new float[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBar1 = (SeekBar) findViewById(R.id.seekBar1);
        mBar2 = (SeekBar) findViewById(R.id.seekBar2);
        mBar3 = (SeekBar) findViewById(R.id.seekBar3);
        mJCircleView = (JCircleView) findViewById(R.id.jCircleView);

        mBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("TAG","0>>>"+progress/100.0+"");
                mPositions[0] = (float)(progress/100.0);
                mJCircleView.setSweepGradientPositions(mPositions);
                mJCircleView.jCircleInvalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("TAG","1>>>"+progress/100.0+"");
                mPositions[1] = (float)(progress/100.0);
                mJCircleView.setSweepGradientPositions(mPositions);
                mJCircleView.jCircleInvalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("TAG","2>>>"+progress/100.0+"");
                mPositions[2] = (float)(progress/100.0);
                mJCircleView.setSweepGradientPositions(mPositions);
                mJCircleView.jCircleInvalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
