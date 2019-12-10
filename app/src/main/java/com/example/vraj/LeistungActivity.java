package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LeistungActivity extends AppCompatActivity implements View.OnClickListener
{
    Button Vergleichbtn, Kreditbtn, Versicherungbtn;

 @Override
    protected void onCreate(Bundle savedInstanceState)
 {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.leistungsauswahl);
     Kreditbtn = (Button)this.findViewById(R.id.Kredit);
     Versicherungbtn = (Button)this.findViewById(R.id.Versicherung);

     Kreditbtn.setOnClickListener(this);
     Versicherungbtn.setOnClickListener(this);


 }
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.Versicherung:                                        // Start der Smartphone Versicherungsvergleich
                Intent Smartphoneintent = new Intent(getApplicationContext(), SmartphoneVersicherungAcitvity.class);
                startActivity(Smartphoneintent);
                break;

            case R.id.Kredit:                             // Start des KreditActivity Vergleichs
                Intent Kreditintent = new Intent(getApplicationContext(), KreditActivity.class);
                startActivity(Kreditintent);
                break;

        }
    }
}