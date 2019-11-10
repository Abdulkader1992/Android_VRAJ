package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Startseite extends AppCompatActivity implements View.OnClickListener {
    Button btnJaJ, btnNeinJ;
    TextView btnAnmldenFrageJ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startseite);
        btnJaJ = (Button) this.findViewById(R.id.btnJa);
        btnNeinJ = (Button) this.findViewById(R.id.btnNein);
        btnAnmldenFrageJ = (TextView) this.findViewById(R.id.btnAnmeldenFrage);

        btnJaJ.setOnClickListener(this);
        btnNeinJ.setOnClickListener(this);
        btnAnmldenFrageJ.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnJa:
                Intent intentJa = new Intent(getApplicationContext(), AnmeldungsSeite.class);
                startActivity(intentJa);
                break;
            case R.id.btnNein:
                Intent intentNein = new Intent(getApplicationContext(), NeuAnmeldungsseite.class);
                startActivity(intentNein);
                break;
            //Alternative
        }
    }
}
