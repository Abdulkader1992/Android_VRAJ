package com.example.vraj;

import android.app.ProgressDialog;
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
import com.google.firebase.database.FirebaseDatabase;

@SuppressWarnings("deprecation")
public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userJ, passJ, passJ2;
    Button nextJ, backJ;
    String username, password, password2;
    private FirebaseAuth auth;
    private  ProgressDialog progressDialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        userJ = (EditText) this.findViewById(R.id.ediUser);
        passJ = (EditText) this.findViewById(R.id.ediPass);
        passJ2 = (EditText) this.findViewById(R.id.ediPass2);
        nextJ = (Button) this.findViewById(R.id.next);
        backJ = (Button) this.findViewById(R.id.backB);

        userJ.setOnClickListener(this);
        passJ.setOnClickListener(this);
        passJ2.setOnClickListener(this);
        nextJ.setOnClickListener(this);
        backJ.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
    }
    public void register () {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        username = userJ.getText().toString().trim();
        password = passJ.getText().toString().trim();
        password2 = passJ2.getText().toString().trim();
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.next:
                register();
                if(TextUtils.isEmpty(username))
                {
                    //Database Speichern
                    Toast.makeText(this, "Bitte geben Sie Ihren Username ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(this, "Bitte geben Sie Ihr Kennwort ein", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password2))
                {
                    Toast.makeText(this, "Bitte bestätigen Sie Ihr Kennwort", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.equals(password2))
                {
                    progressDialog.setMessage("Konto wird gespeichert...");
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(username, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignupActivity.this, "die Dateien wurde erfolgreich gespeichert", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                    } else {
                                        Toast.makeText(SignupActivity.this, "E-Mail ist nicht gültig oder ist bereits vergeben, bitte versuchen Sie noch ein mal", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                    }
                                }
                            });
                    return;
                }
                if(!password.equals(password2))
                {
                    Toast.makeText(this, "Bitte überprüfen Sie Ihr Kennwort", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.backB:
                finish();
                break;
        }
    }
}
