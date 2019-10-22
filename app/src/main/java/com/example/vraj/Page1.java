package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity implements View.OnClickListener {
    Button btnAnmldenJ1, btnSchlissenJ1;
    TextView btreffJ1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnmldenJ1 = (Button) this.findViewById(R.id.btnAnmelden);
        btnSchlissenJ1 = (Button) this.findViewById(R.id.btnSchlissen);
        btreffJ1 = (TextView) this.findViewById(R.id.betreff);

        btnAnmldenJ1.setOnClickListener(this);
        btnSchlissenJ1.setOnClickListener(this);
        btreffJ1.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnmelden:

            case R.id.btnSchlissen:
                finish();
                break;
            case R.id.btnFusszeile:
                //Konrakte
                break;
            //Alternative
        }
    }
}
