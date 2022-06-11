package com.example.unitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_lbs_kgs extends AppCompatActivity {

    TextView txtResult, txtLBs;
    Button btnSave;
    SeekBar sbLBS;
    String savValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbs_kgs);
        setTitle("LBs to KGs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtLBs = findViewById(R.id.txtLBS);
        txtResult = findViewById(R.id.txtResult);
        sbLBS = findViewById(R.id.seekBar);
        btnSave = findViewById(R.id.btnSave);

        sbLBS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int lbs = progress;
                double valKilo = 0.453592;
                double vResult = 0;

                txtLBs.setText(String.valueOf(lbs));

                vResult = lbs*valKilo;

                txtResult.setText(String.valueOf(lbs) + "LBs = " + String.valueOf(vResult) + " KGS.");



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                savValue = txtResult.getText().toString();
                i.putExtra("lk_key",savValue);
                startActivity(i);
            }
        });

    }
}