package com.applus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.applus.task.R;
import com.google.android.material.textfield.TextInputEditText;

import java.net.URI;

public class SmsSendActivity extends AppCompatActivity {
private TextInputEditText telefonText, mesajText;
private Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_send);
        telefonText = findViewById(R.id.telefon);
        mesajText = findViewById(R.id.mesaj);
        sendButton = findViewById(R.id.button1);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse("smsto:" + telefonText.getText().toString());
                   Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                   i.putExtra("sms_body", mesajText.getText().toString());
                   startActivity(i);
                }
                catch(Exception e){
                    Toast.makeText(SmsSendActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}