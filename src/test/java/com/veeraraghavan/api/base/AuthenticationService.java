package com.veeraraghavan.api.base;

import com.veeraraghavan.api.models.request.LoginRequest;
import com.veeraraghavan.api.models.request.SignupRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthenticationService extends BasePage {

    private static final String SERVICE_URL = "/api/auth/";

    public Response login(LoginRequest payload) {
        return postRequest(payload, SERVICE_URL+"login");
    }

    public Response signUp(SignupRequest payload) {
        return postRequest(payload, SERVICE_URL+"signup");
    }

    public Response forgotPassword(String email) {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", email);
        return postRequest(payload, SERVICE_URL+"forgot-password");
    }
}
