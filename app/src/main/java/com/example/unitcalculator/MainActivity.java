package com.example.unitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private Intent intent;

    TextView km_LastSaved, fi_LastSaved, lk_LastSaved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        km_LastSaved = findViewById(R.id.txtkm_lastsaved);
        fi_LastSaved = findViewById(R.id.txtViewFI);
        lk_LastSaved = findViewById(R.id.txtViewLB);

        Intent intent = getIntent();
        final String value = intent.getStringExtra("my_key");
        final String value_FI = intent.getStringExtra("fi_key");
        final String value_LK = intent.getStringExtra("lk_key");
        km_LastSaved.setText(value);
        fi_LastSaved.setText(value_FI);
        lk_LastSaved.setText(value_LK);


        Button btnKM = findViewById(R.id.btnKM);
        btnKM.setOnClickListener(this);

        Button btnFI = findViewById(R.id.btnCalcFI);
        btnFI.setOnClickListener(this);

        Button btnLK = findViewById(R.id.btnCalcLK);
        btnLK.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnKM:
                Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this,km_miles.class);
                startActivity(intent);

                break;
            case R.id.btnCalcFI:
                Toast.makeText(this, "Feet to Inches", Toast.LENGTH_SHORT).show();

                Intent intentFI = new Intent(this,activity_feet_inches.class);
                startActivity(intentFI);

                break;

            case R.id.btnCalcLK:
                Toast.makeText(this, "LBS to KGs", Toast.LENGTH_SHORT).show();

                Intent intentLK = new Intent(this,activity_lbs_kgs.class);
                startActivity(intentLK);

                break;
            default:
                break;
        }

    }
}