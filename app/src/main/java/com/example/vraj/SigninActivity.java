package com.example.vraj;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

@SuppressWarnings("ALL")
public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBack, btnNext, neuKonto;
    static EditText userEingabe, passEingabe;
    Context context;
    String email, password;
    private ProgressDialog dialog;
    private FirebaseAuth auth;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        userEingabe = (EditText) this.findViewById(R.id.ediUser1);
        passEingabe = (EditText) this.findViewById(R.id.ediPass1);
        btnNext = (Button) this.findViewById(R.id.next1);
        btnBack = (Button) this.findViewById(R.id.backB1);
        neuKonto = (Button) this.findViewById(R.id.neuKonto);

        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        neuKonto.setOnClickListener(this);

        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
    }

    private void userCheck()
    {
         email = userEingabe.getText().toString().trim();
         password = passEingabe.getText().toString().trim();

    }
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.neuKonto:
                finish();
                Intent intentJa = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intentJa);
                break;
            case R.id.next1:
                userCheck();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(this, "Bitte geben Sie Ihre E-Mail Adresse ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(this, "Bitte geben Sie Ihr Kennwort ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    {
                    dialog.setMessage("Konto wird überprüft...");
                    dialog.show();
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task)
                                {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SigninActivity.this, "Willkommen zu unserer Leistung", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                        Intent leistungsauswahlintent = new Intent(getApplicationContext(), LeistungActivity.class);
                                        startActivity(leistungsauswahlintent);

                                    } else {
                                        Toast.makeText(SigninActivity.this, "Ihre E-Mail Adresse oder Kennwort ist nicht richtig.", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                }
                            });
                    }
                break;
            case R.id.backB1:
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
                break;
        }
    }
    public static String getEmail()
    {
        String email = userEingabe.getText().toString();
        return email;
    }
}
