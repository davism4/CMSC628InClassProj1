package com.example.neha.serviceexamplenew;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {


    private IBinder mytempbinder = new myBinder();

    public MyService() {
    }



    public class myBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mytempbinder;
    }

    public String sendJunk()
    {
        return "JUNK";
    }

}
