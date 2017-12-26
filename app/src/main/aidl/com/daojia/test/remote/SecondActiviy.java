package com.daojia.test.remote;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.daojia.test.service.BookManagerService;

import java.util.List;


/**
 * Created by allen on 17/12/26.
 */

public class SecondActiviy extends Activity {

    private static final String TAG = SecondActiviy.class.getName();
    private IBookManager iBookManager;

    //死亡代理 当服务端有问题 Binder死亡时 会收到通知
    IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {


            if (iBookManager == null){
                return;
            }

            iBookManager.asBinder().unlinkToDeath(deathRecipient,0);

            //重新绑定远程service
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindService(serviceConnection);
    }





    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iBookManager = IBookManager.Stub.asInterface(service);
            try {

                //客户端绑定服务端后，给binder设置死亡代理
                service.linkToDeath(deathRecipient,0);
                List<Book> bookList = iBookManager.getBookList();



                Log.e(TAG,"query book list, list type: " + bookList.getClass().getCanonicalName());

                Log.e(TAG,"query book list:" + bookList.get(0).bookName + " "+ bookList.get(0).bookId + "  "+ bookList.get(1).bookName + "  "+ bookList.get(1).bookId);

                iBookManager.addBook(new Book(3,"艺术探索"));

                List<Book> newList = iBookManager.getBookList();

                Log.e(TAG,newList.get(2).bookName);
            } catch (RemoteException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }
}
