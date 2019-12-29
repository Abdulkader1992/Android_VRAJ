package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KreditauswertungActivity extends AppCompatActivity implements View.OnClickListener{



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreditauswertung);

        Intent kreditauswertungintent = getIntent();
        int kreditlaufzeit = kreditauswertungintent.getIntExtra("Laufzeit", 1);
        int kreditbetrag = kreditauswertungintent.getIntExtra("Kreditbetrag", 1);
        Toast.makeText(this, String.valueOf(kreditbetrag), Toast.LENGTH_LONG).show();
    }
    public void onClick(View v) {

        }
    }





