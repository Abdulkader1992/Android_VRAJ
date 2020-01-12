package com.example.vraj;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import static android.view.Gravity.CENTER;
import static android.view.Gravity.LEFT;
import static android.view.Gravity.RIGHT;

public class TilgungsPlanActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tilgungsplan);

        Intent tilgungsplanintent = getIntent();

        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
        tableLayout.setStretchAllColumns(true);

        TextView geamtsummeview = (TextView) findViewById(R.id.gesamtsumme);

        int kreditlaufzeit = tilgungsplanintent.getIntExtra("Kreditlaufzeit", 1);
        double kreditsumme = tilgungsplanintent.getFloatExtra("Kreditbetrag", 1);
        String Tilgungsform = tilgungsplanintent.getStringExtra("Tilgungsform");
        float kreditprozentfloat = tilgungsplanintent.getFloatExtra("Kreditprozent", 1);
        double zinsen;
        double annuitat;
        int jahr =0;
        double rueckzahlungssumme = 0;
        double tilgung = 0;


        DecimalFormat euro = new DecimalFormat("###,###.00€");


        if(Tilgungsform.equals("Tilgungsdarlehnen")){
            annuitat = 0;
            tilgung = tilgungsplanintent.getDoubleExtra("Rate", 1);
        }else {
            annuitat = tilgungsplanintent.getDoubleExtra("Rate", 1);
        }

        for (int i = kreditlaufzeit; i >= 1; i--) { //test
            // Creation row
            final TableRow tableRow = new TableRow(this);
            tableRow.setGravity(CENTER);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.MarginLayoutParams.WRAP_CONTENT));
            jahr++;

            for (int j = 0; j < 5; j++) {

                final TextView text = new TextView(this);
                text.setTextSize(14);
                text.setGravity(CENTER);



                zinsen = zinsenberechnunng(kreditprozentfloat, kreditsumme);

                if(Tilgungsform.equals("Annuitätendarlehnen")){
                    tilgung = annuitattilgungberechnung(annuitat, zinsen);
                }

                annuitat = annuitatsberechnung(zinsen, tilgung);





                switch(j){
                    case 0:
                        text.setText(String.valueOf((jahr)));
                        if(i % 2 == 0) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        break;

                    case 1:
                        text.setText(euro.format(kreditsumme));
                        if(i % 2 == 1) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }

                        break;

                    case 2:
                        text.setText(euro.format(zinsen));
                        if(i % 2 == 0) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        break;

                    case 3:
                        text.setText(euro.format(tilgung));
                        if(i % 2 == 1) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        break;

                    case 4:
                        text.setText(euro.format(annuitat));
                        if(Tilgungsform.equals("Tilgungsdarlehen")){


                            rueckzahlungssumme = rueckzahlungssumme + annuitat;

                        }else{
                            kreditsumme = kreditsumme - tilgung;

                            rueckzahlungssumme = rueckzahlungssumme + annuitat;


                        }
                        if(i % 2 == 0) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        break;
                }




                tableRow.addView(text);
                text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            }


            tableLayout.addView(tableRow);

        }


        geamtsummeview.setText(euro.format(rueckzahlungssumme));
        Toast.makeText(this, String.valueOf(rueckzahlungssumme), Toast.LENGTH_SHORT).show();



    }
    public double zinsenberechnunng(double kreditprozentfloatparameter, double kreditsummeparameter){
        double zinsen = kreditsummeparameter * kreditprozentfloatparameter - kreditsummeparameter;
        zinsen = Math.round(zinsen * 100.00) / 100.00;
        return zinsen;
    }
    public double annuitatsberechnung(double zinsenparameter, double tilgunsparameter){
        double annuitat = zinsenparameter + tilgunsparameter;
        annuitat = Math.round(annuitat * 100) / 100.00;
        return annuitat;
    }
    public double annuitattilgungberechnung(double annuitatparameter, double zinsenparameter){
        double tilgungsparameter = annuitatparameter - zinsenparameter;
        tilgungsparameter = Math.round(tilgungsparameter * 100) / 100.00;
        return tilgungsparameter;
    }



}


