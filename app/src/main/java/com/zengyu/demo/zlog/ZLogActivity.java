package com.zengyu.demo.zlog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zengyu.demo.R;
import com.zengyu.wheel.utils.ZLog;
import com.zengyu.wheel.utils.ZLogHelper;

import androidx.appcompat.app.AppCompatActivity;

public class ZLogActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ZLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlog);
        // call once and first
        ZLog.setDebugMode(true);
        ZLog.e("use default tag ZLOG");
        ZLog.e("zengyu", "use custom tag");
        Log.e("zengyu", ZLogHelper.wrapMessage(1, "1 means locate here"));
        LogUtils.e("zengyu", "locate here instead of utils");
    }
}
