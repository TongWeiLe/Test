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


//return false 和 super一样 不拦截 且return super后下次还会走onInterceptTouchEvent
//return true 的话 后续事件up等不再进行询问 直接进入onTouchEvent()
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"LISTVIEW onInterceptTouchEvent");
        return true;
    }
// return true 和 super一样就此终结
    //return false则直接返回Activity的onTouchEvent()且后续事件不会再进入ViewGroup直接走Activity的dispatchTouchEvent onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG,"LISTVIEW onTouchEvent");
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:

                Log.e(TAG,"LISTVIEW ACTION_DOWN"+ev.getAction());

                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"LISTVIEW ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"LISTVIEW ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"LISTVIEW ACTION_UP");
                break;
        }
        return false;
    }

    //return super事件传递给onInterceptTouchEvent
    //return true事件就此终结
    //return false事件回传Activity onTouchEvent(),且后续事件UP等不会再继续进来，直接走Activity的OnTouchEvent()方法
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
