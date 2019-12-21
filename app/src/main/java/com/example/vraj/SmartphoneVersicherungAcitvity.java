package com.example.vraj;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneVersicherungAcitvity extends AppCompatActivity implements View.OnClickListener{

    private Spinner spinner;
    private Button btnSubmitJ;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smartphonversicherung);

        spinner = (Spinner) this.findViewById(R.id.spinner1);
        btnSubmitJ = (Button) this.findViewById(R.id.btnSubmit);

        btnSubmitJ.setOnClickListener(this);
    }
    public  void spinnerShow()
    {
        String handyMarkt = spinner.getSelectedItem().toString();

        switch (handyMarkt)
        {
            case "Huawei":
                Toast.makeText(this, handyMarkt, Toast.LENGTH_SHORT).show();

                break;
            case "Samsung":
                Toast.makeText(this, handyMarkt, Toast.LENGTH_SHORT).show();
                break;

            case "IPhone":
                Toast.makeText(this, handyMarkt, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnSubmit:
                spinnerShow();
                break;
        }
    }
}


