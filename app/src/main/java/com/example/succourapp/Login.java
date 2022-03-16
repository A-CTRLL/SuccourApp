package com.example.succourapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText UserEmail,Userpassword;
    FirebaseAuth mAuth;
    ProgressBar progressBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserEmail = findViewById(R.id.Email);
       Userpassword = findViewById(R.id.password);
        Button Login_btn= findViewById(R.id.Login_Btn);
        Button Regnext= findViewById(R.id.btnRegisterK);
        TextView Userpassword= findViewById(R.id.password);


        progressBar2 = findViewById(R.id.progressBar2);
        Regnext.setOnClickListener(this);
        Login_btn.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        progressBar2.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.Login_Btn:
                LoginUser();
                break;

            case R.id.btnRegisterK:
                startActivity(new Intent(Login.this,RegPage.class));
                break;

        }

    }

    private void LoginUser() {
        String emailaddress = UserEmail.getText().toString().trim();
        String password = Userpassword.getText().toString().trim();

        if (TextUtils.isEmpty(emailaddress)) {
            UserEmail.setError("Email is required!");
            UserEmail.requestFocus();
            return;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailaddress).matches()) {
            UserEmail.setError("Please provide valid email!");
            UserEmail.requestFocus();

        }

        if (TextUtils.isEmpty(password)) {
            Userpassword.setError("password is required!");
            Userpassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            Userpassword.setError("Invalid Password!");
            Userpassword.requestFocus();
            return;
        }

        progressBar2.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(emailaddress,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Login.this,Dash.class));
                    progressBar2.setVisibility(View.GONE);
                }else{
                    Toast.makeText(Login.this, "Invalid User!", Toast.LENGTH_SHORT).show();
                    progressBar2.setVisibility(View.GONE);
                }

            }
        });


    }
}
