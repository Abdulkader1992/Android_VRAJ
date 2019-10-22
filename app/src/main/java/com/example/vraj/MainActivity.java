package com.example.vraj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnAnmldenJ, btnSchlissenJ;
    TextView btreffJ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnmldenJ = (Button)this.findViewById(R.id.btnAnmelden);
        btnSchlissenJ = (Button)this.findViewById(R.id.btnSchlissen);
        btreffJ = (TextView)this.findViewById(R.id.betreff);

        btnAnmldenJ.setOnClickListener(this);
        btnSchlissenJ.setOnClickListener(this);
        btreffJ.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAnmelden:
                // Anmelden
            //    Intent intent = new Intent(MainActivity.this, Page1.class);
            //    MainActivity.startActivity(intent);
                startActivity(new Intent(getApplicationContext(), Page1.class));
                break;
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
