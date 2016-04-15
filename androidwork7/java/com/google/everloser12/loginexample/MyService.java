package com.google.everloser12.loginexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.EventListener;
import java.util.Timer;

public class MyService extends Service {


    private int count;
    Intent intent1;




    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Moi", "Service created");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        intent1 = new Intent(LoginActivity.ACTION_MY);
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                count = (int) (millisUntilFinished / 1000);
                intent1.putExtra(LoginActivity.COUNTER, count);
                sendBroadcast(intent1);
            }

            public void onFinish() {
                count=0;
                intent1.putExtra(LoginActivity.COUNTER, count);
                sendBroadcast(intent1);
                MyService.this.stopSelf();
            }

        }.start();


        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Moi", "Service onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
