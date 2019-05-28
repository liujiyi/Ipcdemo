package com.example.liudachuia.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liudachuia
 * @time 2019/5/28
 * @desc 1，服务端创建一个service来监听客户端的连接请求
 * 2，创建一个aidl文件，将暴露给客户端的接口在这个aidl文件中声名
 * 3，终于第一在service中实现这个aidl接口即可
 */

public class BookManagerSevice extends Service {

    //aidl方法是在服务端的binder线程池中执行，所以采用这个支持并发读写
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();

    private Binder mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
