package com.example.unitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_feet_inches extends AppCompatActivity {

    //Declaring Widgets
    EditText editText1, editText2;
    Button btnSave;
    String savValue;

    private TextWatcher text= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feet_inches);
        setTitle("Feet to Inches");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText1 = findViewById(R.id.edtTxtFeet);
        editText2 = findViewById(R.id.edtTxtInches);
        btnSave = findViewById(R.id.btnSave);

        text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String valueInFeet = editText1.getText().toString();

                if(valueInFeet.length()>0){
                    double Feet = Double.parseDouble(valueInFeet);
                    if(Feet>0){
                        double inches = Feet * 12;
                        editText2.setText(" "+inches);
                    }
                }else{
                    editText2.setText(valueInFeet);
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
                i.putExtra("fi_key",savValue);
                startActivity(i);
            }
        });


    }

}