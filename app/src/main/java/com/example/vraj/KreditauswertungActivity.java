package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class KreditauswertungActivity extends AppCompatActivity {

    TextView kredittextview;
    TextView prozenttextview;
    TextView persoenlichelaufzeitview;
    TextView ratenview;
    TextView ratentextview;
    Button tilgungsplanbtn;

    DecimalFormat euro = new DecimalFormat("###,###.00€");



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreditauswertung);

        kredittextview = (TextView) this.findViewById(R.id.kreditsumme);
        prozenttextview = (TextView) this.findViewById(R.id.prozent);
        persoenlichelaufzeitview = (TextView) this.findViewById(R.id.persönlicheLaufzeit);
        ratenview = (TextView) this.findViewById(R.id.rate);
        ratentextview = (TextView) this.findViewById(R.id.ratentext);
        tilgungsplanbtn = (Button) this.findViewById(R.id.tilgungsplan);


        Intent kreditauswertungintent = getIntent();
        int kreditlaufzeit = kreditauswertungintent.getIntExtra("Laufzeit", 1);
        float kreditbetrag = kreditauswertungintent.getFloatExtra("Kreditbetrag", 1);
        String tilgungsform = kreditauswertungintent.getStringExtra("Tilgungsform");
        float kreditprozentfloat;
        int kreditprozent;
        double rate;
        String ratentext;
        String hinweis;


        if (kreditlaufzeit <= 2) {
            kreditprozentfloat = 1.06f;
            kreditprozent = 6;
        } else if (kreditlaufzeit <= 5) {
            kreditprozentfloat = 1.08f;
            kreditprozent = 8;
        } else {
            kreditprozentfloat = 1.10f;
            kreditprozent = 10;
        }


        if (tilgungsform.equals("Tilgungsdarlehnen")) {
            rate = tilgungsberechnung(kreditlaufzeit, kreditbetrag);
            ratentext = " \nTilgungsrate";
            hinweis = " \nzzgl. variabler Zinsen";
        } else {
            rate = annuitatsberechnung(kreditlaufzeit, kreditbetrag, kreditprozentfloat);
            ratentext = " \nAnnuitätsrate";
            hinweis = "";
        }


        double kreditgesamtsumme = kreditbetrag * kreditprozentfloat;
        kreditgesamtsumme = Math.round(kreditgesamtsumme * 100.00) / 100.00;


        Toast.makeText(this, String.valueOf(tilgungsform), Toast.LENGTH_SHORT).show();


        String prozentstring = String.valueOf(kreditprozent) + " Prozent";
        String persoenlichelaufzeitstring = String.valueOf(kreditlaufzeit + " Jahre");

        ratentextview.setText("Jährliche" + ratentext + hinweis);

        ratenview.setText(euro.format(rate));

        kredittextview.setText(euro.format(kreditbetrag));
        prozenttextview.setText(prozentstring);
        persoenlichelaufzeitview.setText(persoenlichelaufzeitstring);

        setOnClick(rate, kreditbetrag, kreditprozentfloat, kreditlaufzeit, tilgungsform);

    }

    public double annuitatsberechnung(int kreditlaufzeitparameter, float kreditbetragparameter, float kreditprozentfloatparameter) {
        double annuitatsrate = kreditbetragparameter * (Math.pow(kreditprozentfloatparameter, kreditlaufzeitparameter));
        double annuitatsratemultiplikator = kreditprozentfloatparameter - 1.0f;
        annuitatsratemultiplikator = annuitatsratemultiplikator / (Math.pow(kreditprozentfloatparameter, kreditlaufzeitparameter) - 1.0f);
        annuitatsrate = annuitatsrate * annuitatsratemultiplikator;
        annuitatsrate = Math.round(annuitatsrate * 100.00) / 100.00;
        return annuitatsrate;
    }

    public double tilgungsberechnung(int kreditlaufzeitparameter, float kreditbetragparameter) {
        float tilgungsrate = kreditbetragparameter / kreditlaufzeitparameter;
        return tilgungsrate;
    }

    private void setOnClick(final double rateparameter, final float kreditbetragparameter, final float kreditprozentfloatparameter, final int kreditlaufzeitparameter, final String tilgungsformparameter) { // Lösungsansatz von Stackoverflow übernommen: https://stackoverflow.com/questions/10614696/how-to-pass-parameters-to-onclicklistener/25399586
        tilgungsplanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tilgungsplanintent = new Intent(getApplicationContext(), TilgungsPlanActivity.class);

                tilgungsplanintent.putExtra("Rate", rateparameter);
                tilgungsplanintent.putExtra("Kreditbetrag", kreditbetragparameter);
                tilgungsplanintent.putExtra("Kreditprozent",kreditprozentfloatparameter);
                tilgungsplanintent.putExtra("Kreditlaufzeit", kreditlaufzeitparameter);
                tilgungsplanintent.putExtra("Tilgungsform", tilgungsformparameter);
                startActivity(tilgungsplanintent);
            }
        });

    }
}







