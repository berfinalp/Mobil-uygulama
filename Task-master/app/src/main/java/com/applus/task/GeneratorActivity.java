package com.applus.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneratorActivity extends AppCompatActivity {

    private TextInputEditText adetText, maxText, minText;
    private Button generateButton;
    private ListView listview1;
    private ArrayList<HashMap<String, Object>> progressMap = new ArrayList<>();
    private RandomNumbers r = new RandomNumbers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        //set values from layout file
        adetText = findViewById(R.id.adettext);
        minText = findViewById(R.id.mintext);
        maxText = findViewById(R.id.maxtext);

        generateButton = findViewById(R.id.generatebutton);

        listview1 = findViewById(R.id.listview1);


        //generate button click listener
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if (checkInputs()){
    if (Integer.valueOf(minText.getText().toString())<Integer.valueOf(maxText.getText().toString())){
        progressMap.clear();
        for (int i=0; i<Integer.valueOf(adetText.getText().toString()); i++){
            {
                r.randomize(Integer.valueOf(minText.getText().toString()), Integer.valueOf(maxText.getText().toString()));
                HashMap<String, Object> _item = new HashMap<>();
                _item.put("firstnum", r.getFirstNumber());
                _item.put("secondnum", r.getSecondNumber());
                _item.put("between", r.getBetweenNum());
                _item.put("percentage", r.getPercentage());
                progressMap.add(_item);
            }

            ProgressList progressList = new ProgressList(progressMap, getApplicationContext());
            listview1.setAdapter(progressList);
        }
    }else {
        Toast.makeText(GeneratorActivity.this, "Maximum ve Minimum değerleri doğru giriniz.", Toast.LENGTH_SHORT).show();
    }






}else {
    Toast.makeText(GeneratorActivity.this, "Kaç adet olduğunu giriniz", Toast.LENGTH_SHORT).show();
}
            }
        });
    }


    private Boolean checkInputs(){
        return !(adetText.getText().toString().length() == 0 || minText.getText().toString().length() == 0 || maxText.getText().toString().length() == 0);
    }



}





