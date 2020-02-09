package com.example.vraj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();
    Button btnAnmldenJ, btnSchlissenJ, btnKontaktJ;
    ImageView btreffJ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnmldenJ = (Button)this.findViewById(R.id.btnSingIn);
        btnSchlissenJ = (Button)this.findViewById(R.id.btnClose);
        btreffJ = (ImageView)this.findViewById(R.id.betreff);
        btnKontaktJ = (Button)this.findViewById(R.id.btnWe);

        btnAnmldenJ.setOnClickListener(this);
        btnSchlissenJ.setOnClickListener(this);
        btreffJ.setOnClickListener(this);
        btnKontaktJ.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSingIn:
                Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(intent);
                break;
            case R.id.btnClose:

                finish();
                break;
            case R.id.btnWe:

                Intent infoIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(infoIntent);
                break;

        }
    }
}
