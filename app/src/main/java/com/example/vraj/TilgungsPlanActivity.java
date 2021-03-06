package com.example.vraj;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import static android.view.Gravity.CENTER;

public class TilgungsPlanActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tilgungsplan);

        Intent tilgungsplanintent = getIntent();

        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
        tableLayout.setStretchAllColumns(true);

        TextView geamtsummeview = (TextView) findViewById(R.id.gesamtsumme);

        int idindex = 1;

        Button grafischerTilgungsplanbtn = new Button(this);
        grafischerTilgungsplanbtn.setId( idindex );
        grafischerTilgungsplanbtn.setText("Grafischen Tilgungsplan erstellen");
        grafischerTilgungsplanbtn.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.MarginLayoutParams.WRAP_CONTENT) );


        int kreditlaufzeit = tilgungsplanintent.getIntExtra("Kreditlaufzeit", 1);
        double kreditsumme = tilgungsplanintent.getFloatExtra("Kreditbetrag", 1);
        String Tilgungsform = tilgungsplanintent.getStringExtra("Tilgungsform");
        float kreditprozentfloat = tilgungsplanintent.getFloatExtra("Kreditprozent", 1);
        double zinsen;
        double annuitat;
        int jahr =0;
        double rueckzahlungssumme = 0;
        double tilgung = 0;
        double restschuld[] = new double[kreditlaufzeit];
        double zinsenarray [] = new double[kreditlaufzeit];
        double tilgungarray[] = new double[kreditlaufzeit];
        double annuitatsrate [] = new double[kreditlaufzeit];

        DecimalFormat euro = new DecimalFormat("###,###.00€");


        if(Tilgungsform.equals("Tilgungsdarlehen")){
            annuitat = 0;
            tilgung = tilgungsplanintent.getDoubleExtra("Rate", 1);
        }else {
            annuitat = tilgungsplanintent.getDoubleExtra("Rate", 1);
        }

        // Ab hier beginnt die Erstellung des Tilgungsplan
        for (int i = kreditlaufzeit; i >= 1; i--) {
            // Erstellung einer Zeile
            final TableRow tableRow = new TableRow(this);
            tableRow.setGravity(CENTER);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.MarginLayoutParams.WRAP_CONTENT));
            jahr++;

            // Die 5 beschreibt die Anzahl der Spalten
            for (int j = 0; j < 5; j++) {

                final TextView text = new TextView(this);
                text.setTextSize(14);
                text.setGravity(CENTER);



                zinsen = zinsenberechnunng(kreditprozentfloat, kreditsumme);

                if(Tilgungsform.equals("Annuitätendarlehen")){
                    tilgung = annuitattilgungberechnung(annuitat, zinsen);
                }

                annuitat = annuitatsberechnung(zinsen, tilgung);




                // Die Arrays innerhalb der Cases wird dazu benötigt um die Einzel Ergebnisse später als Bar Chart auszugeben.
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
                        restschuld[i - 1] = kreditsumme;
                        text.setText(euro.format(kreditsumme));
                        if(i % 2 == 1) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }

                        break;

                    case 2:
                        zinsenarray[i - 1] = zinsen;
                        text.setText(euro.format(zinsen));
                        if(i % 2 == 0) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        break;

                    case 3:
                        tilgungarray[i - 1] = tilgung;
                        text.setText(euro.format(tilgung));
                        if(i % 2 == 1) {
                            text.setBackgroundColor(Color.rgb(38, 234, 255));
                        }else{
                            text.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        break;

                    case 4:
                        annuitatsrate[i - 1] = annuitat;
                        text.setText(euro.format(annuitat));

                            kreditsumme = kreditsumme - tilgung;

                            rueckzahlungssumme = rueckzahlungssumme + annuitat;



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

        tableLayout.addView( grafischerTilgungsplanbtn );
        setOnClick( grafischerTilgungsplanbtn, kreditlaufzeit, restschuld, zinsenarray, tilgungarray, annuitatsrate );


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


    private void setOnClick(final Button grafischerTilgungsplanbtnparameter, final int kreditlaufzeitparameter, final double restschuldparameter[], final double zinsenarrayparameter[], final double tilgungarray[], final double annuitatsrateparameter[]) { // Lösungsansatz von Stackoverflow übernommen: https://stackoverflow.com/questions/10614696/how-to-pass-parameters-to-onclicklistener/25399586
        grafischerTilgungsplanbtnparameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Test", String.valueOf(kreditlaufzeitparameter));

                Intent tilgungschartintent = new Intent(getApplicationContext(), Tilgungschart.class);


                Bundle restschuldbundle = new Bundle(  );
                Bundle zinsenbundle = new Bundle(  );
                Bundle tilgungsbudle = new Bundle(  );
                Bundle annuitatbundle = new Bundle(  );


                restschuldbundle.putDoubleArray("Restschuld", restschuldparameter);
                zinsenbundle.putDoubleArray("Zinsen", zinsenarrayparameter);
                tilgungsbudle.putDoubleArray("Tilgung", tilgungarray);
                annuitatbundle.putDoubleArray("Annuitat", annuitatsrateparameter);


                tilgungschartintent.putExtra("Kreditlaufzeit", kreditlaufzeitparameter);
                tilgungschartintent.putExtra( "Restschuldbundle", restschuldbundle );
                tilgungschartintent.putExtra( "Zinsenbundle", zinsenbundle );
                tilgungschartintent.putExtra( "Tilgungbundle", tilgungsbudle );
                tilgungschartintent.putExtra( "Annuitatbundle", annuitatbundle );

                startActivity(tilgungschartintent);


            }
        });

    }

    }




