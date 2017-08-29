package com.daojia.test;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by allen on 17/8/29.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton implements View.OnTouchListener{

    final String TAG = "mybutton";

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.e(TAG,"BUTTON  onTouch");
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,"BUTTON dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.setBackgroundColor(Color.parseColor("#FF4081"));

                Log.e(TAG,"BUTTON ACTION_DOWN");

                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"BUTTON ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_MOVE:
                this.setBackgroundColor(Color.parseColor("#000000"));
                Log.e(TAG,"BUTTON ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                this.setBackgroundColor(Color.parseColor("#3F51B5"));
                Log.e(TAG,"BUTTON ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
