package com.damiencgprotonmail.bilanciami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.Buttonhelp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhelplayout();
            }
        });
    }

    /** Called when the user taps the buttonhelp button */
    public void openhelplayout() {
        Intent intent = new Intent(this, help.class);
        startActivity(intent);
    }
}

