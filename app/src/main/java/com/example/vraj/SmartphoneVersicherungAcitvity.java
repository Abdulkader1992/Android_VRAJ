package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SmartphoneVersicherungAcitvity extends AppCompatActivity implements View.OnClickListener{

    private static Spinner spinner1;
    private static Spinner spinner2;
    private static Spinner spinner3;
    private Button btnSubmitJ;
    private static EditText preisEingabe;
    private static Double versicherung;
    private Button btnInfo;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smartphonversicherung);

        spinner1 = (Spinner) this.findViewById(R.id.spinner1);
        spinner2 = (Spinner) this.findViewById(R.id.spinner2);
        spinner3 = (Spinner) this.findViewById(R.id.spinner3);
        btnSubmitJ = (Button) this.findViewById(R.id.btnSubmit);
        btnInfo = (Button) this.findViewById(R.id.info);
        preisEingabe = (EditText) this.findViewById(R.id.preisEingabe);

        btnSubmitJ.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
    }
                // Spinner Rechnungen

    public double herstellerAuswahl()
    {
        String hersteller = spinner1.getSelectedItem().toString();
        double herstellerErgebnis = 0;

        switch (hersteller) {
            case "Nokia":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 1;
                break;
            case "Motorela":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 2;
                break;
            case "Wiko":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 1;
                break;
            case "HTC":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 2;
                break;
            case "LG":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 2;
                break;
            case "OnePlus":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 2;
                break;
            case "Oppo":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 1;
                break;
            case "Sony":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 3;
                break;
            case "Vivo":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 1;
                break;
            case "ZTE":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 2;
                break;
            case "Huawei":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 1;
            break;
            case "Samsung":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 2;
            break;

            case "IPhone":
                //Toast.makeText(this, hersteller, Toast.LENGTH_SHORT).show();
                herstellerErgebnis = 3;
            break;
        }
        return herstellerErgebnis;
    }
    public double alterAuswahl()
    {
        String alter = spinner2.getSelectedItem().toString();
        double alterErgebnis = 0;

        switch (alter) {
            case "ein Monat oder weniger":
                //Toast.makeText(this, alter, Toast.LENGTH_SHORT).show();
                alterErgebnis = 1;
                break;
            case "von 1 bis 6 Monate":
                //Toast.makeText(this, alter, Toast.LENGTH_SHORT).show();
                alterErgebnis = 2;
                break;
            case "mehr als 6 Monate":
                //Toast.makeText(this, alter, Toast.LENGTH_SHORT).show();
                alterErgebnis = 3;
                break;
        }
        return alterErgebnis;
    }
    public double diebstahlAuswahl()
    {
        String diebstahl = spinner3.getSelectedItem().toString();
        double diebstahlErgebnis = 0;
        switch (diebstahl)
        {
            case "Ja":
                //Toast.makeText(this, diebstahl, Toast.LENGTH_SHORT).show();
                diebstahlErgebnis = 1;
                break;
            case "Nein":
                //Toast.makeText(this, diebstahl, Toast.LENGTH_SHORT).show();
                diebstahlErgebnis = 2;
                break;
        }
        return diebstahlErgebnis;
    }

    @Override
    public void onClick(View v)
    {
        String preis = preisEingabe.getText().toString();
        if(preis.isEmpty())
        {
            String fehlermeldung = "Sie haben eine ungültige Eingabe eingetragen!";
            Toast.makeText(this, fehlermeldung, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Double preisZahl = Double.valueOf(preis).doubleValue();
            switch (v.getId()) {
                case R.id.btnSubmit:

                    if (herstellerAuswahl() == 1) //  ************************************
                    {
                        if (alterAuswahl() == 1)  // weniger als einen Monat----------
                        {
                            if (diebstahlAuswahl() == 1) // Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.01)) + 2;    // Formel                                           §
                            } else if (diebstahlAuswahl() == 2) // Diebstahl nicht versichert (Nein)
                            {
                                versicherung = (preisZahl * (0.01));    // Formel                                               §
                            }
                        } else if (alterAuswahl() == 2) // Weniger als 6 Monaten--------
                        {
                            if (diebstahlAuswahl() == 1) // Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.012)) + 2;    // Formel                                          §
                            } else if (diebstahlAuswahl() == 2) // Diebstahl nicht versichert (Nein)
                            {
                                versicherung = (preisZahl * (0.012)); // Formel                                                 §
                            }

                        } else if (alterAuswahl() == 3) // Mehr als 6 Monaten----------
                        {
                            if (diebstahlAuswahl() == 1) //Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.015)) + 2; // Formel                                             §
                            } else if (diebstahlAuswahl() == 2) //Diebstahl nicht versicehrt (Nein)
                            {
                                versicherung = (preisZahl * (0.015));    // Formel                                              §
                            }
                        }

                    } else if (herstellerAuswahl() == 2) //  ******************************+
                    {
                        if (alterAuswahl() == 1)  // weniger als einen Monat----------
                        {
                            if (diebstahlAuswahl() == 1) // Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.012)) + 2;// Formel                                              §
                            } else if (diebstahlAuswahl() == 2) // Diebstahl nicht versichert (Nein)
                            {
                                versicherung = (preisZahl * (0.012)); // Formel                                                 §
                            }
                        } else if (alterAuswahl() == 2) // Weniger als 6 Monaten--------
                        {
                            if (diebstahlAuswahl() == 1) // Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.015)) + 2; // Formel                                             §
                            } else if (diebstahlAuswahl() == 2) // Diebstahl nicht versichert (Nein)
                            {
                                versicherung = (preisZahl * (0.015)); // Formel                                                 §
                            }

                        } else if (alterAuswahl() == 3) // Mehr als 6 Monaten----------
                        {
                            if (diebstahlAuswahl() == 1) //Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.018)) + 2; // Formel                                             §
                            } else if (diebstahlAuswahl() == 2) //Diebstahl nicht versicehrt (Nein)
                            {
                                versicherung = (preisZahl * (0.018)); // Formel                                                 §
                            }
                        }
                    } else if (herstellerAuswahl() == 3) //  ********************************
                    {
                        if (alterAuswahl() == 1)  // weniger als einen Monat----------
                        {
                            if (diebstahlAuswahl() == 1) // Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.015)) + 3;// Formel                                              §
                            } else if (diebstahlAuswahl() == 2) // Diebstahl nicht versichert (Nein)
                            {
                                versicherung = (preisZahl * (0.015)); // Formel                                                 §
                            }
                        } else if (alterAuswahl() == 2) // Weniger als 6 Monaten--------
                        {
                            if (diebstahlAuswahl() == 1) // Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.018)) + 3;// Formel                                              §
                            } else if (diebstahlAuswahl() == 2) // Diebstahl nicht versichert (Nein)
                            {
                                versicherung = (preisZahl * (0.018));// Formel                                                  §
                            }

                        } else if (alterAuswahl() == 3) // Mehr als 6 Monaten----------
                        {
                            if (diebstahlAuswahl() == 1) //Diebstahl versichert (JA)
                            {
                                versicherung = (preisZahl * (0.02)) + 3;// Formel                                               §
                            } else if (diebstahlAuswahl() == 2) //Diebstahl nicht versicehrt (Nein)
                            {
                                versicherung = (preisZahl * (0.02));// Formel                                                   §
                            }
                        }
                    }
                    if(preisZahl <= 2500 && preisZahl >= 100) {
                        Intent intent = new Intent(getApplicationContext(), HandyVersicherungErgebnisActivity.class);
                        startActivity(intent);
                        break;
                    }
                    else if(preisZahl < 100)
                    {
                        String fehlermeldung = "Ihr Handy-Einkaufpreis ist zu niedrig! \n Wir vergeben nur Handyeikaufpreise ab 100 Euro!";
                        Toast.makeText(this, fehlermeldung, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else
                    {
                        String fehlermeldung = "Ihr Handy-Einkaufpreis ist zu hoch! \n Wir vergeben nur Handyeikaufpreise bis zu 2500 Euro!";
                        Toast.makeText(this, fehlermeldung, Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.info:

                    Intent infoIntent = new Intent(getApplicationContext(), InfoActivity.class);
                    startActivity(infoIntent);
                    break;

                default:
                    throw new IllegalStateException("\n" + "Unerwarteter Wert: " + v.getId());
            }
        }
    }


    // Spinner anzeigen

    public static String herstellerView()
    {
        String hersteller = spinner1.getSelectedItem().toString();
        return hersteller;
    }
    public static String alterView()
    {
        String alter = spinner2.getSelectedItem().toString();
        return alter;
    }
    public static String diebstahlView()
    {
        String diebstahl = spinner3.getSelectedItem().toString();
        return diebstahl;
    }
    public static String kaufpreisView()
    {
        String kaufpreis = preisEingabe.getText().toString();
        return kaufpreis;
    }
    public static double zahlungView()
    {
        //VersicherungErgebnisse anzeigen

        double ergebnis = Math.round(versicherung * 100) / 100.0;
        return (ergebnis);
    }
}


