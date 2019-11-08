package com.example.vraj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Leistungen extends AppCompatActivity implements View.OnClickListener {
    Button btnAnmldenJ1, btnSchlissenJ1;
    TextView btreffJ1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leistungen);
        btnAnmldenJ1 = (Button) this.findViewById(R.id.btnAnmeldenFrage);
        btnSchlissenJ1 = (Button) this.findViewById(R.id.btnJa);
        btreffJ1 = (TextView) this.findViewById(R.id.betreff);

        btnAnmldenJ1.setOnClickListener(this);
        btnSchlissenJ1.setOnClickListener(this);
        btreffJ1.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnmeldenFrage:

            case R.id.btnJa:
                finish();
                break;
            case R.id.btnPass:
                //Kontakte
                break;
            //Alternative
        }
    }
}