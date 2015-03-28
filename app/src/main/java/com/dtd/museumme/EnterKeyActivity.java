package com.dtd.museumme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 123 on 28.03.2015.
 */
public class EnterKeyActivity extends Activity {

    private static String VALID_KEY = "007";

    TextView text;
    EditText keyValue;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_key);

        text = (TextView)findViewById(R.id.keyText);
        keyValue = (EditText)findViewById(R.id.keyValue);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputKey = keyValue.getText().toString();
                if(inputKey.equals(VALID_KEY)){
                    Intent intent = new Intent(EnterKeyActivity.this, MuseumActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(EnterKeyActivity.this, "Неверный ключ", Toast.LENGTH_LONG);
                    keyValue.setText("");
                }
            }
        });
    }
}
