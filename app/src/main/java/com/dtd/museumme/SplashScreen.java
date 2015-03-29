package com.dtd.museumme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Egor on 28.03.2015.
 */
public class SplashScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        Thread logoTimer = new Thread()
        {
            public void run()
            {
                try {

                    sleep(3450);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(SplashScreen.this, TabsActivity.class));
                finish();
            }
        };
        logoTimer.start();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
