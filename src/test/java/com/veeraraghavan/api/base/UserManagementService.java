package com.veeraraghavan.api.base;

import com.veeraraghavan.api.models.request.UpdateUserProfileRequest;
import io.restassured.response.Response;

public class UserManagementService extends BasePage {

    private static final String SERVICE_URL = "/api/users/";

    public Response getUserProfile(String token) {
        setAuthToken(token);
        return getRequest(SERVICE_URL + "profile");
    }

    public Response updateUserProfile(UpdateUserProfileRequest payload, String token) {
        setAuthToken(token);
        return putRequest(payload, SERVICE_URL + "profile");
    }
}
