package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LeistungActivity extends AppCompatActivity implements View.OnClickListener
{
    Button infoBtn, kreditbtn, versicherungbtn;

 @Override
    protected void onCreate(Bundle savedInstanceState)
 {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.leistungsauswahl);
     kreditbtn = (Button)this.findViewById(R.id.kredit);
     versicherungbtn = (Button)this.findViewById(R.id.versicherung);
     infoBtn = (Button) this.findViewById(R.id.btnWe);


     kreditbtn.setOnClickListener(this);
     versicherungbtn.setOnClickListener(this);
     infoBtn.setOnClickListener(this);


 }
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.versicherung:                                        // Start der Smartphone Versicherungsvergleich
                Intent Smartphoneintent = new Intent(getApplicationContext(), SmartphoneVersicherungAcitvity.class);
                startActivity(Smartphoneintent);
                break;

            case R.id.kredit:                             // Start des KreditActivity Vergleichs
                Intent Kreditintent = new Intent(getApplicationContext(), KreditActivity.class);
                startActivity(Kreditintent);
                break;

            case R.id.btnWe:
                Intent infoIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(infoIntent);

        }
    }
}
