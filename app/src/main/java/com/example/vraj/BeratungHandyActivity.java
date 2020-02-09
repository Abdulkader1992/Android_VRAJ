package com.example.vraj;

import android.content.ActivityNotFoundException;
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


public class BeratungHandyActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameJ, lastnameJ;
    DatePicker picker;
    Button nextJ, backJ;
    String nameString, lastnameString , mailSignin;

    private String hersteller,alter,diebstahl,kaufpreis,zahlung;

    private FirebaseAuth auth;
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


        nextJ.setOnClickListener(this);
        backJ.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        hersteller = SmartphoneVersicherungAcitvity.herstellerView();
        alter = SmartphoneVersicherungAcitvity.alterView();
        diebstahl = SmartphoneVersicherungAcitvity.diebstahlView();
        kaufpreis = SmartphoneVersicherungAcitvity.kaufpreisView();
        zahlung = euro.format(SmartphoneVersicherungAcitvity.zahlungView());
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



                String smartphonekonditionen =  "\n \n Meine Versicherungskonditionen:\n" +
                        "\n" + "Hersteller:\t" + hersteller +
                        "\n" + "Alter:\t" + alter +
                        "\n" + "Diebstalschutz:\t" + diebstahl +
                        "\n" + "Kaufpreis:\t" + kaufpreis +
                        "\n" + "Zahlung:\t" + zahlung +
                        "\n\nVielen\tDank.\n\n";

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ebdo93@gmail.com","juergen-mayer.1@gmx.de"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Beratungstermin");
                i.putExtra(Intent.EXTRA_TEXT   , "Liebes\tTeam\tvom\tVRAJ,\n\n\n" +
                        "hiermit\tmöchte\tich\tfür\tdie\tkommenden\tTage\teinen\tverbindlichen\tBeratungstermin\tfür\t\n" +
                        "eine\tDirektberatung\tvereinbaren.\n\nMeine\tpersönliche\tDaten:\n\n" +
                        "Name:\t" + nameString + "\t" + lastnameString +
                        "\nGeburtsdatum:\t" + picker.getDayOfMonth()  +"."+  picker.getMonth()+"."+ picker.getYear() +
                        "\nE-Mail-Adresse:\t" + mailSignin +
                        smartphonekonditionen +
                        "Mit\tfreundlichen\tGrüßen" + "\n\n" + nameString);
                try {
                    startActivity(Intent.createChooser(i, "Sende Mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(BeratungHandyActivity.this, "Es sind keine Mail-Clients installiert, weshalb die Mail nicht versendet werden kann.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.backV:
                finish();
                break;

        }
    }
}
