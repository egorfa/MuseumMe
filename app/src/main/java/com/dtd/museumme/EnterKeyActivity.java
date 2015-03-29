package com.dtd.museumme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 123 on 28.03.2015.
 */
public class EnterKeyActivity extends Activity {

    private static String VALID_KEY = "007";

    TextView text, price;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_key);

        text = (TextView)findViewById(R.id.contentDescr);
        price = (TextView)findViewById(R.id.price);
        btnPay = (Button)findViewById(R.id.btnPay);

        final String FONT = "fonts/Roboto-Light.ttf";
        Typeface typeface;
        typeface = Typeface.createFromAsset(getAssets(), FONT);
        text.setTypeface(typeface);
        price.setTypeface(typeface);
        btnPay.setTypeface(typeface);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterKeyActivity.this, MuseumActivity.class);
                startActivity(intent);
            }
        });
    }
}
