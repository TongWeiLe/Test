package com.daojia.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.daojia.test.MyListView;
import com.daojia.test.R;
import com.daojia.test.TestAdapter;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    final String TAG = "mainactivity";

    MyListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (MyListView) findViewById(R.id.lv_test);

        listView.setAdapter(new TestAdapter(this));


//        listView.setOnTouchListener(this);


    }
//只能返回super false 和true事件都会被终结 不再向下传递，如果有ViewGroup的话不会走自己的OnTouchEvent
    //如果下面没有ViewGroup 则会走自己的OnTouchEvent 且不管onTouchEvent里面返回什么下次事件还是会走OnTouchEvent

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {



        Log.e(TAG,"MainActivity  dispatchTouchEvent ");

//        if (super.dispatchTouchEvent(ev)){
//            Log.e(TAG,"MainActivity  parent  dispatchTouchEvent");
//        }

//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            onUserInteraction();
//
//            Log.e(TAG," onUserInteraction ");
//        }
//        if (getWindow().superDispatchTouchEvent(ev)) {
//
//            Log.e(TAG," superDispatchTouchEvent ");
//
//            return true;
//        }
//        return onTouchEvent(ev);

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity  onTouchEvent");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                Log.e(TAG,"Activity ACTION_DOWN");

                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"Activity ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"Activity ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"Activity ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.e(TAG,"onTouch");
        return false;
    }
}
