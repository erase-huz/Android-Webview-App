package com.webview.application;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;


public class SplashActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < Integer.parseInt(getString(R.string.splash_delay))) {
                        sleep(100);
                        waited += 100;
                    }

                } catch (InterruptedException e) {
                    // do nothing
                } finally {

                    finish();

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);


                }
            }
        };
        splashThread.start();
    }


}
