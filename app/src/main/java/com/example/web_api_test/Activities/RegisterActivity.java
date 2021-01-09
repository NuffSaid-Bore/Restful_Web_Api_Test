package com.example.web_api_test.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.web_api_test.API_Services.ApiClient;
import com.example.web_api_test.Models.RegisterRequest;
import com.example.web_api_test.R;
import com.example.web_api_test.Repositories.RegisterResponse;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText username,mail,pass,con_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.Username);
        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        con_pass = findViewById(R.id.conPass);

    }

    public void RegisterUser(View view)
    {

        if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(mail.getText().toString())
        || TextUtils.isEmpty(pass.getText().toString()) || TextUtils.isEmpty(con_pass.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Populate All fields please!", Toast.LENGTH_SHORT).show();
        }
        else {
        RegisterRequest request = new RegisterRequest();
        request.setEmail(mail.getText().toString());
        request.setUsername(username.getText().toString());
        request.setPassword(pass.getText().toString());

        Register(request);
        }
    }

    public void Register(RegisterRequest registerRequest)
    {

        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(RegisterActivity.this, "User registration was successful", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "An Error occurred! "+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "An Error occurred! "+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}