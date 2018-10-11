package com.example.darius.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        etEmail = findViewById(R.id.emailLogin);
        etPassword = findViewById(R.id.passwordLogin);
    }

    public void checkLogin(View v) {
        if (etEmail.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
            startActivity(new Intent(LoginActivity.this, Welcome.class));
        } else {
            Toast.makeText(LoginActivity.this, "Invalid user or password.", Toast.LENGTH_LONG).show();
        }
    }
}
