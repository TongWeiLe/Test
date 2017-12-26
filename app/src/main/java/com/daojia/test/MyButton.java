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

    //return false事件回传给ViewGroup的onTouchEvent(),且后续事件不会再询问 直接走ViewGroup dispatchTouchEvent 然后走 OnTouchEvent()
    //return true 事件被拦截 不再传递
    //return super事件传递给onTouchEvent()
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        this.setOnTouchListener(this);
        Log.e(TAG,"BUTTON dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }


    //return true 和 return super一样 事件就此终结
    //return false后续事件不会再进入Button甚至dispatchTouchEvent()
    //return false事件会回传给ViewGroup的OnTouchEvent() 如果它返回super 或者 true则事件就此终结 如果ViewGroup返回false则继续上传到Acvivity的onTouchEvent() 无论它返回什么事件就此终结
    //return false后续事件up则直接从ViewGroup的dispatchTouchEvent中直接进入onTouchEvent()
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.setBackgroundColor(Color.parseColor("#FF4081"));

                Log.e(TAG,"BUTTON ACTION_DOWN"+event.getAction());

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