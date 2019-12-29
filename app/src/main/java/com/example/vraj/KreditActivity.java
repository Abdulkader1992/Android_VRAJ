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
    EditText kreditbetragview;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kredit);
        abschickenbtn = (Button)this.findViewById(R.id.abschicken);
        laufzeitspinner = (Spinner)this.findViewById(R.id.spinnerlaufzeit);
        kreditbetragview = (EditText)this.findViewById(R.id.kreditbetrag);

        abschickenbtn.setOnClickListener(this);
    }
    public void onClick(View v) {
        String laufzeittext = laufzeitspinner.getSelectedItem().toString();
        String kreditbetragstring = kreditbetragview.getText().toString();
        int kreditbetrag = Integer.parseInt(kreditbetragstring);



        switch (laufzeittext) {
            case "1 Jahr":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(12, kreditbetrag);
                break;
            case "2 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(24, kreditbetrag);
                break;
            case "3 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(36, kreditbetrag);
                break;
            case "4 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(48, kreditbetrag);
                break;
            case "5 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(60, kreditbetrag);
                break;
            case "6 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(72, kreditbetrag);
                break;
            case "7 Jahre":
                Toast.makeText(this, laufzeittext, Toast.LENGTH_SHORT).show();
                KreditauswertungIntentMethod(84, kreditbetrag);
                break;


        }
    }
    public void KreditauswertungIntentMethod(int laufzeitparameter, int kreditbetragparameter){
        Intent kreditauswertungintent = new Intent(getApplicationContext(), KreditauswertungActivity.class);
        kreditauswertungintent.putExtra("Laufzeit", laufzeitparameter);
        kreditauswertungintent.putExtra("Kreditbetrag", kreditbetragparameter);
        startActivity(kreditauswertungintent);
    }


}
