package com.example.unitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class km_miles extends AppCompatActivity {

    //Declaring Widgets
    //Declaring Widgets

    EditText editText1, editText2;
    Button btnSave;
    String savValue;

    private TextWatcher text= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_miles);
        setTitle("KM to miles");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instaniating Widgets

        editText1 = findViewById(R.id.edtTxtFeet);
        editText2 = findViewById(R.id.edtTxtInches);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String valueInKilo = editText1.getText().toString();

                if(valueInKilo.length()>0){
                    double Kilo = Double.parseDouble(valueInKilo);

                    if(Kilo>0){
                        double pound = Kilo * 2.205;
                        editText2.setText(" "+pound);
                    }else{
                        editText2.setText("0");
                    }

                }else{

                    editText2.setText(valueInKilo);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editText1.addTextChangedListener(text);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                savValue = editText1.getText().toString()+"KM "+editText2.getText().toString()+"Miles ";
                i.putExtra("my_key",savValue);
                startActivity(i);
            }
        });
    }
}