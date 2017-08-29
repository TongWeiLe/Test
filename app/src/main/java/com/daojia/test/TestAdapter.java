package com.daojia.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by allen on 17/8/29.
 */

public class TestAdapter extends BaseAdapter {

    Context context;

    LayoutInflater linearLayout;
    public TestAdapter(Context context) {
        this.context = context;
        linearLayout = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = linearLayout.inflate(R.layout.item,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

//        viewHolder.button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                switch (motionEvent.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        view.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//                        view.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
//                        break;
//
//
//                }
//
//                return true;
//            }
//        });


        return view;
    }

    class ViewHolder{
        MyButton button;

        public ViewHolder(View view) {
            button = (MyButton) view.findViewById(R.id.button);
        }
    }
}
