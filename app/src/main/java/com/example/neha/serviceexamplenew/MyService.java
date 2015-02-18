package com.example.neha.serviceexamplenew;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    public String stringRSA, stringRSG;

    Boolean isCollecting = false;

    public void BeginCollect()
    {
        if (!isCollecting) // Lock controls when already busy
        {
            isCollecting = true;
            stringRSA = "RSA";
            stringRSG = "RSG";
        }
    }

    public void EndCollect()
    {
        if (isCollecting) // Lock controls when already busy
        {
            isCollecting = false;
        }
    }

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
