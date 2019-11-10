package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NeuAnmeldungsseite extends AppCompatActivity implements View.OnClickListener {

    EditText userJ, passJ;
    TextView frageNeuJ;
    Button saveJ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neuanmeldungsseite);
        userJ = (EditText) this.findViewById(R.id.ediUserNeu);
        passJ = (EditText) this.findViewById(R.id.ediPassNeu);
        frageNeuJ = (TextView) this.findViewById(R.id.betreffNeuAnmeldung);
        saveJ = (Button) this.findViewById(R.id.save);

        userJ.setOnClickListener(this);
        passJ.setOnClickListener(this);
        frageNeuJ.setOnClickListener(this);
        saveJ.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ediUserNeu:

                break;
            case R.id.ediPassNeu:

                break;
            case R.id.save:

                //Speichern
        }
    }
}
