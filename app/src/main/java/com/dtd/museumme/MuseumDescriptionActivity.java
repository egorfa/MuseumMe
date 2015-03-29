package com.dtd.museumme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Egor on 28.03.2015.
 */
public class MuseumDescriptionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_description);

        Intent intent = getIntent();
        Museum museum = intent.getParcelableExtra("Museum");


    }
}
