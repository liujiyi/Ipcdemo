package com.example.liudachuia.ipc.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.liudachuia.ipc.R;
import com.example.liudachuia.ipc.utils.MyUtils;

/**
 * @author liudachuia
 * @time 2019/5/28
 * @desc 1，绑定服务端的serview
 * 2，将服务端返回的binder对象转成aidl接口所属的类型 接着就可以调用aidl的方法了
 */
public class BookManagerActivity extends AppCompatActivity {

    private TextView mDescTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_a);

        mDescTv = findViewById(R.id.decs_tv);

        String processName = MyUtils.getProcessName(this, Process.myPid());
        mDescTv.setText("进程名：" + processName);

        Intent intent = new Intent(this, BookManagerSevice.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBookManager bookManager = IBookManager.Stub.asInterface(iBinder);
            try {
                mDescTv.setText("没加之前：" + bookManager.getBookList().toString());

                bookManager.addBook(new Book(998, "liudachuia"));
                bookManager.addBook(new Book(9999, "liudachuia"));
                bookManager.addBook(new Book(999999, "liudachuia"));

                mDescTv.setText(mDescTv.getText() + "\n" + "加了3本之后：" + bookManager.getBookList().toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }

    //    /**
//     * bundle通信
//     *
//     * @param view
//     */
//    public void goBundleSecond(View view) {
//        Intent intent = new Intent(this, BundleBProcessActivity.class);
//
//        Book book = new Book(999, "liudachuia");
//        intent.putExtra("bundle", book);
//        startActivity(intent);
//    }
}
