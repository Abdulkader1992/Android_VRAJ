package com.example.vraj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();
    Button btnAnmldenJ, btnSchlissenJ, ohneAnmelungfortfahrenJ, btnKontaktJ;
    TextView btreffJ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnmldenJ = (Button)this.findViewById(R.id.btnSingIn);
        btnSchlissenJ = (Button)this.findViewById(R.id.btnClose);
        btreffJ = (TextView)this.findViewById(R.id.betreff);
        ohneAnmelungfortfahrenJ = (Button)this.findViewById(R.id.btnWithoutSingIn);
        btnKontaktJ = (Button)this.findViewById(R.id.btnWe);

        btnAnmldenJ.setOnClickListener(this);
        btnSchlissenJ.setOnClickListener(this);
        btreffJ.setOnClickListener(this);
        ohneAnmelungfortfahrenJ.setOnClickListener(this);
        btnKontaktJ.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSingIn:                                        // Anmeldung Button
                Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(intent);
                break;

            case R.id.btnWithoutSingIn:
                Intent leistungsauswahlintent = new Intent(getApplicationContext(), LeistungActivity.class);
                startActivity(leistungsauswahlintent);                                      // Ohne Anmeldung Button
                break;

            case R.id.btnClose:
                                                        // App beenden Button
                finish();
                break;
            case R.id.btnWe:
                                                        // Konrakte Button
                break;
                                                        // Alternative
        }
    }
}
