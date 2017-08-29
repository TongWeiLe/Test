package com.daojia.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    final String TAG = "mainactivity";

    MyListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (MyListView) findViewById(R.id.lv_test);

        listView.setAdapter(new TestAdapter(this));


        listView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e(TAG,"MainActivity  dispatchTouchEvent ");

        if (super.dispatchTouchEvent(ev)){
            Log.e(TAG,"MainActivity  parent  dispatchTouchEvent");
        }

        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity  onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Log.e(TAG,"MainActivity  onTouch");
        return false;
    }
}
