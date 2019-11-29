package com.example.vraj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnmeldungsSeite extends AppCompatActivity implements View.OnClickListener {

    EditText userJ, passJ;
    TextView editAskJ;
    Button nextJ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anmedungsseite);
        userJ = (EditText) this.findViewById(R.id.ediUser);
        passJ = (EditText) this.findViewById(R.id.ediPass);
        editAskJ = (TextView) this.findViewById(R.id.userEingabe);
        nextJ = (Button) this.findViewById(R.id.next);

        userJ.setOnClickListener(this);
        passJ.setOnClickListener(this);
        editAskJ.setOnClickListener(this);
        nextJ.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ediUser:

                break;
            case R.id.ediPass:

                break;
            case R.id.next:

                break;
        }
    }
}
