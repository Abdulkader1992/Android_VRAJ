package com.example.vraj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button btnAnmldenJ, btnSchlissenJ;
    TextView btreffJ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAnmelden:
                // Anmelden
                break;
            case R.id.btnSchlissen:
                finish();
                break;
            case R.id.btnFusszeile:
                //Konrakte
                break;
            default:
                //Alternative
        }
    }
}
