package com.applus.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ConverterActivity extends AppCompatActivity {
    private String[] taban = { "İkilik", "Sekizlik",
            "On altılık"};
    private String[] bytes = { "Kilobyte", "Byte",
            "Kibibyte", "Bit"};
    private String[] cel = {"Fahrenheit", "Kelvin"};

    private Spinner tabanSpinner, byteSpinner, celspinner;
    private int currentTabanSpinner, currentByteSpinner, currentCelSpinner;
    private TextInputEditText decimalText, byteText, celText;
    private TextView sonuc, byteSonuc, celSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        decimalText = findViewById(R.id.sayiinput);
        sonuc = findViewById(R.id.sonuc);
        tabanSpinner = findViewById(R.id.spinner);
        byteSpinner = findViewById(R.id.bytespinner);
        byteText = findViewById(R.id.byteinput);
        byteSonuc = findViewById(R.id.bytesonuc);
        celspinner = findViewById(R.id.celspinner);
        celText = findViewById(R.id.celinput);
        celSonuc = findViewById(R.id.celsonuc);



        //decimal actions start
        ArrayAdapter tabanAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, taban);
        tabanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tabanSpinner.setAdapter(tabanAdapter);

        tabanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentTabanSpinner = position;
                hesaplaTaban();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
decimalText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        hesaplaTaban();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});
//decimal actions finish here

        //byte actions started here
        ArrayAdapter byteAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bytes);
        byteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        byteSpinner.setAdapter(byteAdapter);

        byteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentByteSpinner = position;
                hesaplaByte();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        byteText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hesaplaByte();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //byte actions finish here

        //celsius actions start here

        ArrayAdapter celAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cel);
        celAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        celspinner.setAdapter(celAdapter);


        celspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentCelSpinner = position;
                hesaplaCel();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        celText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hesaplaCel();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //celsius actions finish here

    }

    private void hesaplaTaban (){
 if (!(decimalText.getText().toString().length() == 0)){
     switch (currentTabanSpinner){
         case 0:
             try {
                 sonuc.setText(Integer.toBinaryString(Integer.valueOf(decimalText.getText().toString())));

             }catch (Exception e){
                 sonuc.setText("Invalid Input");

             }

             break;

         case 1:
             try {
                 sonuc.setText(Integer.toOctalString(Integer.valueOf(decimalText.getText().toString())));

             }catch (Exception e){
                 sonuc.setText("Invalid Input");
             }

             break;

         case 2:
             try {
                 sonuc.setText(Integer.toHexString(Integer.valueOf(decimalText.getText().toString())));

             }catch (Exception e){
                 sonuc.setText("Invalid Input");
             }

             break;
     }
 }else {
     sonuc.setText(" ");
 }
    }


    private void hesaplaByte(){
        if (!(byteText.getText().toString().length() == 0)){
            switch (currentByteSpinner){
                case 0:
                    try {
                        byteSonuc.setText(String.valueOf(megaByteToKiloByte(Integer.valueOf(byteText.getText().toString()))));

                    }catch (Exception e){
                        byteSonuc.setText("Invalid Input");
                    }
                    break;

                case 1:
                    try {
                        byteSonuc.setText(String.valueOf(megaByteToByte(Integer.valueOf(byteText.getText().toString()))));

                    }catch (Exception e){
                        byteSonuc.setText("Invalid Input");
                    }
                    break;

                case 2:
                    try {
                        byteSonuc.setText(String.valueOf(megaByteToKibiByte(Integer.valueOf(byteText.getText().toString()))));

                    }catch (Exception e){
                        byteSonuc.setText("Invalid Input");
                    }
                    break;

                case 3:
                    try {
                        byteSonuc.setText(String.valueOf(megaByteToBit(Integer.valueOf(byteText.getText().toString()))));

                    }catch (Exception e){
                        byteSonuc.setText("Invalid Input");
                    }
                    break;

            }
        }else {
            byteSonuc.setText(" ");
        }


    }

private void hesaplaCel(){
    if (!(celText.getText().toString().length() == 0)){
        switch (currentCelSpinner){
            case 0:
                try {
                    celSonuc.setText(String.valueOf(celsiusToFahrenheit(Integer.valueOf(celText.getText().toString()))));

                }catch (Exception e){
                    celSonuc.setText("Invalid input");
                }
                break;

            case 1:
                try {
                    celSonuc.setText(String.valueOf(celsiusToKelvin(Integer.valueOf(celText.getText().toString()))));

                }catch (Exception e){
                    celSonuc.setText("Invalid input");

                }

                break;

        }
    }else {
        celSonuc.setText(" ");
    }
}



    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }


    public static double megaByteToKiloByte(double megaByte) {
        return megaByte * 1024;
    }

    public static double megaByteToByte(double megaByte) {
        return megaByte * 1024 * 1024;
    }

    public static double megaByteToKibiByte(double megaByte) {
        return megaByte * 8 * 1024;
    }

    public static double megaByteToBit(double megaByte) {
        return megaByte * 8 * 1024 * 1024;
    }
}