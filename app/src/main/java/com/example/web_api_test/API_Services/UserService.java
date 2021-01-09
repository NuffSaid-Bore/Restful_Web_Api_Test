package com.example.web_api_test.API_Services;

import com.example.web_api_test.Models.LoginRequest;
import com.example.web_api_test.Models.RegisterRequest;
import com.example.web_api_test.Repositories.LoginResponse;
import com.example.web_api_test.Repositories.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService
{
    @POST("authenticate/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("users/")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
