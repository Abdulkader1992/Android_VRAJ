package com.example.vraj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class HandyVersicherungErgebnisActivity extends AppCompatActivity implements View.OnClickListener{

    private Button infobtn;
    private TextView hersteller;
    private TextView alter;
    private TextView diebstahl;
    private TextView kaufpreis;
    private TextView zahlung;

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
        infobtn.setOnClickListener(this);

        hersteller.setText(SmartphoneVersicherungAcitvity.herstellerView());
        alter.setText(SmartphoneVersicherungAcitvity.alterView());
        diebstahl.setText(SmartphoneVersicherungAcitvity.diebstahlView());
        kaufpreis.setText(SmartphoneVersicherungAcitvity.kaufpreisView());
        zahlung.setText(SmartphoneVersicherungAcitvity.zahlungView());
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSubmit:
                break;
        }
    }
}


