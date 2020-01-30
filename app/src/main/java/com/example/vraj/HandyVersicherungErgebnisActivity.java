package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class HandyVersicherungErgebnisActivity extends AppCompatActivity implements View.OnClickListener{

    private Button infobtn, abschickenJ;
    private TextView hersteller;
    private TextView alter;
    private TextView diebstahl;
    private TextView kaufpreis;
    private TextView zahlung;
    DecimalFormat euro = new DecimalFormat("###,###.00€");

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handyversicherungergebnis);

        hersteller = (TextView) this.findViewById(R.id.view12);
        alter      = (TextView) this.findViewById(R.id.view22);
        diebstahl  = (TextView) this.findViewById(R.id.view32);
        kaufpreis  = (TextView) this.findViewById(R.id.view42);
        zahlung    = (TextView) this.findViewById(R.id.view52);


        infobtn    = (Button) this.findViewById(R.id.info1);
        abschickenJ = (Button) this.findViewById(R.id.abschlissen);
        infobtn.setOnClickListener(this);
        abschickenJ.setOnClickListener(this);

        hersteller.setText(SmartphoneVersicherungAcitvity.herstellerView());
        alter.setText(SmartphoneVersicherungAcitvity.alterView());
        diebstahl.setText(SmartphoneVersicherungAcitvity.diebstahlView());
        kaufpreis.setText(SmartphoneVersicherungAcitvity.kaufpreisView());
        zahlung.setText(euro.format(SmartphoneVersicherungAcitvity.zahlungView()));
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.info1:
                Intent infoIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(infoIntent);
                break;
            case R.id.abschlissen:
                Intent vertragIntent = new Intent(getApplicationContext(), BeratungHandyActivity.class);
                startActivity(vertragIntent);
        }
    }
}


