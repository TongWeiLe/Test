package com.daojia.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by allen on 17/8/29.
 */

public class MyListView extends ListView  implements View.OnTouchListener{
    final String TAG = "mylistview";

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"LISTVIEW onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG,"LISTVIEW onTouchEvent");
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"LISTVIEW  dispatchTouchEvent");

//        if (super.dispatchTouchEvent(ev)){
//            Log.e(TAG,"LISTVIEW  parent  dispatchTouchEvent");
//        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.e(TAG,"LISTVIEW  onTouch");
        return false;
    }
}
