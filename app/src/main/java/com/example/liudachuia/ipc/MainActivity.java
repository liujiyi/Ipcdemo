package com.example.liudachuia.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.liudachuia.ipc.aidl.BookManagerActivity;
import com.example.liudachuia.ipc.bundle.BundleAProcessActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * bundle通信
     *
     * @param view
     */
    public void bundle(View view) {
        //只能传输bundle支持的数据类型
        //适合场景：四大组件建的进程间通信
        startActivity(new Intent(this, BundleAProcessActivity.class));
    }

    /**
     * 文件共享
     *
     * @param view
     */
    public void file(View view) {
        //TODO 实现代码
        //IO操作 对文件进行读写来实现进程间的通信
        //不适合高并发场景（读写操作，多线程，你懂的。）并且无法做到即时通信

    }

    /**
     * messenger
     *
     * @param view
     */
    public void messenger(View view) {
        //TODO 实现代码
        //基于aidl 轻量级的ipc方案
        //使用场景：低并发的一对多即时通信 无RPC需求，或者无需返回结果的rpc需求
    }

    /**
     * aidl
     *
     * @param view
     */
    public void aidl(View view) {
        startActivity(new Intent(this, BookManagerActivity.class));
    }

    /**
     * 内容提供者
     *
     * @param view
     */
    public void conterprovider(View view) {
        //TODO 实现代码
        //四大组件之一（eg：系统的通讯录信息等）
        //使用场景：一对多的进程间的数据共享
    }

    /**
     * socket通信
     *
     * @param view
     */
    public void socket(View view) {
        //TODO 实现代码
        //socket 套接字，进行网络通信（TCP UDP）
        //使用场景：通络数据交换
    }
}
