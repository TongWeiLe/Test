package com.daojia.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.daojia.test.remote.Book;
import com.daojia.test.remote.IBookManager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by allen on 17/12/26.
 */

public class BookManagerService extends Service {

    private static final String TAG = "BMS";

    //支持并发读写 AIDL是运行在Binder线程池的 所以多个客户端同时连接的时候 会存在多线程同时访问的情形
    //所以我们需要在AIDL中处理多线程同步
    //虽然AIDL中只能用ArrayList 但是AIDL是支持List这个抽象的接口 因此虽然服务端返回的是CopyOnWriteArrayList 但是在Binder中会按照List的规范去访问数据 最后返回一个ArrayList返回给客户端

    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();

    private Binder binder = new IBookManager.Stub(){

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mBookList.add(new Book(1,"android"));
        mBookList.add(new Book(2,"ios"));
    }
}
