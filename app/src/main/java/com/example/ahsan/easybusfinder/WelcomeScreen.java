package com.example.ahsan.easybusfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeScreen extends Activity {
    private static int SPLASH_TIME_OUT=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // remove title

        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent=new Intent(WelcomeScreen.this,navigation_drawer.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

    }

}
