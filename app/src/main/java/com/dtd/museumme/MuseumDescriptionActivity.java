package com.dtd.museumme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.Button;

/**
 * Created by Egor on 28.03.2015.
 */
public class MuseumDescriptionActivity extends Activity {

    ImageView img, imgLogo;
    TextView title, address, time, phone, description;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_description);

        Museum museum = getIntent().getParcelableExtra("Museum");

        img = (ImageView)findViewById(R.id.museumImg);
        title = (TextView)findViewById(R.id.museumTitle);
        address = (TextView)findViewById(R.id.museumAddress);
        time = (TextView)findViewById(R.id.museumTime);
        phone = (TextView)findViewById(R.id.museumPhone);
        description = (TextView)findViewById(R.id.museumDescription);
        button = (Button)findViewById(R.id.button);

        title.setText(museum.getTitle());
        address.setText(museum.getAddress());
        time.setText(museum.getTime());
        phone.setText(museum.getPhone());
        description.setText(museum.getDescription());

        String FONT = "fonts/Roboto-Light.ttf";
        String FONT1 = "fonts/Roboto-Medium.ttf";
        Typeface typeface;
        typeface = Typeface.createFromAsset(getAssets(), FONT);

        title.setTypeface(typeface);
        typeface = Typeface.createFromAsset(getAssets(), FONT1);
        address.setTypeface(typeface);
        time.setTypeface(typeface);
        phone.setTypeface(typeface);
        description.setTypeface(typeface);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuseumDescriptionActivity.this, EnterKeyActivity.class);
                startActivity(intent);
            }
        });


        TextView title = (TextView)getActionBar().getCustomView().findViewById(R.id.actionbarTitle);
        title.setText("Музей");
        ImageView leftArrow = (ImageView)getActionBar().getCustomView().findViewById(R.id.btn_menu);
        leftArrow.setBackground(getResources().getDrawable(R.drawable.left_arrow));

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuseumDescriptionActivity.this, TabsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        /*Intent intent = new Intent(MuseumDescriptionActivity.this, TabsActivity.class);
        startActivity(intent);*/
        finish();

    }

}
