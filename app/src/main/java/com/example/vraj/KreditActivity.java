package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KreditActivity extends AppCompatActivity implements View.OnClickListener{

    Button abschickenbtn;
    Spinner laufzeitspinner;
    Spinner tilgungsartspinner;
    EditText kreditbetragview;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kredit);
        abschickenbtn = (Button)this.findViewById(R.id.abschicken);
        laufzeitspinner = (Spinner)this.findViewById(R.id.spinnerlaufzeit);
        tilgungsartspinner = (Spinner)this.findViewById(R.id.tilgungsform);
        kreditbetragview = (EditText)this.findViewById(R.id.kreditbetrag);

        abschickenbtn.setOnClickListener(this);
    }
    public void onClick(View v) {
        String laufzeittext = laufzeitspinner.getSelectedItem().toString();
        String tilgungsart = tilgungsartspinner.getSelectedItem().toString();
        String kreditbetragstring = kreditbetragview.getText().toString();
        float kreditbetrag = Float.parseFloat(kreditbetragstring);



        switch (laufzeittext) {
            case "1 Jahr":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(1, kreditbetrag, tilgungsart);
                break;
            case "2 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(2, kreditbetrag, tilgungsart);
                break;
            case "3 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(3, kreditbetrag, tilgungsart);
                break;
            case "4 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(4, kreditbetrag, tilgungsart);
                break;
            case "5 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(5, kreditbetrag, tilgungsart);
                break;
            case "6 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(6, kreditbetrag, tilgungsart);
                break;
            case "7 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(7, kreditbetrag, tilgungsart);
                break;


        }
    }
    public void KreditauswertungIntentMethod(int laufzeitparameter, float kreditbetragparameter, String tilgungsformparameter){
        Intent kreditauswertungintent = new Intent(getApplicationContext(), KreditauswertungActivity.class);
        kreditauswertungintent.putExtra("Laufzeit", laufzeitparameter);
        kreditauswertungintent.putExtra("Kreditbetrag", kreditbetragparameter);
        kreditauswertungintent.putExtra("Tilgungsform", tilgungsformparameter);
        startActivity(kreditauswertungintent);
    }


}
