package com.example.liudachuia.ipc.bundle;

import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.liudachuia.ipc.R;
import com.example.liudachuia.ipc.bean.Book;
import com.example.liudachuia.ipc.utils.MyUtils;

public class BundleBProcessActivity extends AppCompatActivity {

    private TextView mDescTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_a);

        mDescTv = findViewById(R.id.decs_tv);

        StringBuilder sb = new StringBuilder();
        String processName = MyUtils.getProcessName(this, Process.myPid());
//        mDescTv.setText("进程名："+processName);
        sb.append("进程名："+processName);
        Book book = (Book) getIntent().getSerializableExtra("bundle");
        sb.append("\n").append(book.toString());
        mDescTv.setText(sb.toString());
    }

    /**
     * bundle通信
     * @param view
     */
    public void goBundleSecond(View view) {

    }
}
