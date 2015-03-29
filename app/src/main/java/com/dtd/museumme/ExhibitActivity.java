package com.dtd.museumme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by 123 on 28.03.2015.
 */
public class ExhibitActivity extends Activity {

    Exhibit exhibit;
    ImageView img;
    TextView text, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_item);


        title = (TextView)findViewById(R.id.exhibitTitle);
        text = (TextView)findViewById(R.id.exhibitText);
        img = (ImageView)findViewById(R.id.exhibitImg);


        com.gc.materialdesign.views.Button icon = (com.gc.materialdesign.views.Button) findViewById(R.id.button);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
// repeat many times:
        Button itemAudio = new Button(this);
        //itemAudio.setBackground(getResources().getDrawable(R.drawable.pin));
        SubActionButton button1 = itemBuilder.setContentView(itemAudio).build();

        Button itemVideo = new Button(this);
        //itemVideo.setBackground(getResources().getDrawable(R.drawable.play_icon));
        SubActionButton button2 = itemBuilder.setContentView(itemVideo).build();


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .attachTo(icon)
                .build();


        exhibit = getIntent().getParcelableExtra("Object");


        int id = getResources().getIdentifier("contentexample_" + exhibit.getImageExhibit(), "drawable", getPackageName());

        title.setText(exhibit.getTitleExhibit());
        text.setText(exhibit.getTextExhibit());
        img.setImageResource(id);
    }

    public void setFonts (View view) {
        final String LIGHT_FONT = "fonts/HelveticaNeueCyr-Light.otf";
        final String NORMAL_FONT = "fonts/Helv-5-Normal.pfb";
        final String ITALIC_FONT = "fonts/HelveticaNeueCyr-Italic.otf";
        final String BOLD_FONT = "fonts/HelveticaNeueCyr-Bold.otf";

        Typeface typeface;

        typeface = Typeface.createFromAsset(getAssets(), LIGHT_FONT);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(ExhibitActivity.this, MuseumActivity.class);
        startActivity(intent);
        finish();

    }
}
