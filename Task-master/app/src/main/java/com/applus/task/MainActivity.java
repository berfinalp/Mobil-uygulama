package com.applus.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.applus.SmsSendActivity;

public class MainActivity extends AppCompatActivity {
private LinearLayout infoLayout, buttonLayout;
private TextView schoolTextview, usernameTextview;
private Button button1, button2, button3;
private Intent i = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set values from layout files
        infoLayout = findViewById(R.id.infolayout);
        buttonLayout = findViewById(R.id.buttonlayout);
        schoolTextview = findViewById(R.id.schoolnum);
        usernameTextview = findViewById(R.id.username);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
//button animations

        button1.setAlpha(0f);
        button1.setTranslationY(50);
        button1.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        button2.setAlpha(0f);
        button2.setTranslationY(50);
        button2.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        button3.setAlpha(0f);
        button3.setTranslationY(50);
        button3.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        //Button click listeners

        //button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirect
                i.setClass(MainActivity.this, ConverterActivity.class);
                startActivity(i);
            }
        });

        //button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setClass(MainActivity.this, GeneratorActivity.class);
                startActivity(i);
            }
        });

        //button3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setClass(MainActivity.this, SmsSendActivity.class);
                startActivity(i);
            }
        });

    }
}