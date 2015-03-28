package com.dtd.museumme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 123 on 28.03.2015.
 */
public class ExhibitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_item);

        setActionBar();
    }

    public void setActionBar(){
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        View customView = getLayoutInflater().inflate(R.layout.actionbar_center, null);
        TextView title = (TextView) findViewById(R.id.actionbarTitle);
        title.setText("Экспонаты");

        actionBar.setCustomView(customView);
    }
}
