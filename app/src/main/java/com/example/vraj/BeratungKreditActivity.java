package com.example.vraj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class BeratungKreditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameJ, lastnameJ;
    Button nextJ, backJ;
    String nameString, lastnameString, mailSignin;
    DatePicker picker;

    private Intent vertragIntent;

    private FirebaseAuth auth;
    private ProgressDialog progressDialog;
    DecimalFormat euro = new DecimalFormat("###,###.00€");
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beratung);
        nameJ = (EditText) this.findViewById(R.id.vornameEingabe);
        lastnameJ = (EditText) this.findViewById(R.id.nachnameEingabe);
        nextJ = (Button) this.findViewById(R.id.nextV);
        backJ = (Button) this.findViewById(R.id.backV);
        picker = (DatePicker) this.findViewById(R.id.datePicker1);

        vertragIntent = getIntent();
        double rate = vertragIntent.getDoubleExtra("Rate", 1);
        int kreditlaufzeit = vertragIntent.getIntExtra("Kreditlaufzeit" , 2);
        double kreditsumme = vertragIntent.getDoubleExtra("Kreditbetrag", 1);
        String tilgungsform = vertragIntent.getStringExtra("Tilgungsform" );
        int kreditprozentfloat = vertragIntent.getIntExtra("Kreditprozent", 1);


        nextJ.setOnClickListener(this);
        backJ.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();

    }
    public void register () {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        nameString = nameJ.getText().toString().trim();
        lastnameString = lastnameJ.getText().toString().trim();
        mailSignin = SigninActivity.getEmail();
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.nextV:

                register();
                if(TextUtils.isEmpty(nameString))
                {
                    Toast.makeText(this, "Bitte geben Sie Ihren Vorname ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(lastnameString))
                {
                    Toast.makeText(this, "Bitte geben Sie Ihr Nachname ein", Toast.LENGTH_SHORT).show();
                    return;
                }

                DecimalFormat euro = new DecimalFormat("###,###.00€");


                Intent vertragIntent = getIntent();
                double rate = vertragIntent.getDoubleExtra( "Rate", 1 );
                int kreditlaufzeit = vertragIntent.getIntExtra("Kreditlaufzeit", 1);
                double kreditsumme = vertragIntent.getFloatExtra("Kreditbetrag", 1);
                String Tilgungsform = vertragIntent.getStringExtra("Tilgungsform");
                int kreditprozentfloat = vertragIntent.getIntExtra("Kreditprozent", 1);

                String kreditkonditionen = "\n \n Meine berechneten Kreditkonditionen: \n \n Kreditsumme: " + euro.format(kreditsumme) + "\n Kreditlaufzeit: " + kreditlaufzeit + " Jahre\n" +
                        " Tilgungsform: " + Tilgungsform + "\n Zinsen: " + kreditprozentfloat + "%" + "\n Rate: " + euro.format(rate);




                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ebdo93@gmail.com","juergen-mayer.1@gmx.de"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Beratungstermin");
                i.putExtra(Intent.EXTRA_TEXT   , "Liebes\tTeam\tvom\tVRAJ,\n\n\n" +
                        "hiermit\tmöchte\tich\tfür\tdie\tkommenden\tTage\teinen\tverbindlichen\tBeratungstermin\tfür\t\n" +
                        "eine\tDirektberatung\tvereinbaren.\n\nMeine\tpersönliche\tDaten:\n\n" +
                        "Name:\t" + nameString + "\t" + lastnameString +
                        "\nGeburtsdatum:\t" + picker.getDayOfMonth() + "." + picker.getMonth() + "." + picker.getYear() +
                        "\nE-Mail-Adresse:\t" + mailSignin +
                        kreditkonditionen +
                        "\n\nVielen\tDank.\n\n" +

                        "Mit\tfreundlichen\tGrüßen" + "\n\n" + nameString);
                try {
                    startActivity(Intent.createChooser(i, "Sende Mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(BeratungKreditActivity.this, "Es sind keine Mail-Clients installiert, weshalb die Mail nicht versendet werden kann.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.backV:
                finish();
                break;

        }
    }
}
