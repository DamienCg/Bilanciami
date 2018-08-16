package com.damiencgprotonmail.bilanciami;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button openhelp;
    private Button opensetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Open Help*/
        openhelp = (Button) findViewById(R.id.Buttonhelp);
        openhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhelplayout();
            }
        });


        /** Open Setting*/
        opensetting = (Button) findViewById(R.id.buttonsetting);
        opensetting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                opensettinglayout();
            }
        });



    } /** END ONCREATE */

    /** Called when the user taps the  button */
    public void openhelplayout() {
        Intent intent = new Intent(this, help.class);
        startActivity(intent);
    }

    public void opensettinglayout() {
        Intent intent = new Intent(this, SettigActivity.class);
        startActivity(intent);
    }


}