package com.example.weiduapp;

import android.app.Application;
import android.content.Context;

import com.example.weiduapp.umlogin.Contstans;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

public class App extends Application {

    public static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext=this;
        initUmeng();

    }

    private void initUmeng() {
        //第三方登陆
        UMConfigure.init(mcontext, Contstans.APPKEY
                ,null ,UMConfigure.DEVICE_TYPE_PHONE,null);
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        //gug
        CrashReport.initCrashReport(getApplicationContext(), "d9883bc2a8", true);

    }

}
