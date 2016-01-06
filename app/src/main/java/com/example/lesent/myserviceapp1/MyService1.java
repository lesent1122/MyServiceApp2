package com.example.lesent.myserviceapp1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService1 extends Service {
    public MyService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new Binder();
    }
    public class Binder extends android.os.Binder{

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("OnStart---启动服务");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("OnCreste---开始创建");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy---销毁服务");

    }
}
