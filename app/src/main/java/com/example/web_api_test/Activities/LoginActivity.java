package com.example.web_api_test.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.web_api_test.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.LogMail);
        pass = findViewById(R.id.Logpass);

    }

    public void Register(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    public void LoginUser(View view)
    {

    }
}