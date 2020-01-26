package com.example.vraj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

@SuppressWarnings("deprecation")//
public class BeratungActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameJ, lastnameJ, dateJ, mailJ;
    Button nextJ, backJ;
    String nameString, lastnameString ,dateString, mailString;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beratung);
        nameJ = (EditText) this.findViewById(R.id.vornameEingabe);
        lastnameJ = (EditText) this.findViewById(R.id.nachnameEingabe);
        dateJ = (EditText) this.findViewById(R.id.geburtsdatumEingabe);
        mailJ = (EditText) this.findViewById(R.id.emailVEingabe);
        nextJ = (Button) this.findViewById(R.id.nextV);
        backJ = (Button) this.findViewById(R.id.backV);


        nextJ.setOnClickListener(this);
        backJ.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
    }
    public void register () {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        nameString = nameJ.getText().toString().trim();
        lastnameString = lastnameJ.getText().toString().trim();
        dateString = dateJ.getText().toString().trim();
        mailString = mailJ.getText().toString().trim();
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
                if (TextUtils.isEmpty(dateString))
                {
                    Toast.makeText(this, "Bitte geben Sie die Anrede ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mailString)) {
                    Toast.makeText(this, "Bitte geben Sie Ihre E-Mail-Adresse ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ebdo93@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Beratungstermin");
                i.putExtra(Intent.EXTRA_TEXT   , "Liebes\tTeam\tvom\tVRAJ,\n\n\n" +
                        "hiermit\tmöchte\tich\tfür\tdie\tkommenden\tTage\teinen\tverbindlichen\tBeratungstermin\tfür\t\n" +
                        "eine\tDirektberatung\tvereinbaren.\n\nMeine\tpersönliche\tDaten:\n" +
                        "Name:\t" + nameString + "\t" + lastnameString + "\nGeburtsdatum:\t" + dateString +
                        "\nE-Mail-Adresse:\t" + mailString + "\n\nVielen\tDank.\n\n" +
                        "Mit\tfreundlichen\tGrüßen" + "\n\n" + nameString);
                try {
                    startActivity(Intent.createChooser(i, "Sende Mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(BeratungActivity.this, "Es sind keine Mail-Clients installiert, weshalb die Mail nicht versendet werden kann.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.backV:
                //Intent createIntent = new Intent(getApplicationContext(), CreateActivity.class);
                //startActivity(createIntent);
                finish();
                break;

        }
    }
}
