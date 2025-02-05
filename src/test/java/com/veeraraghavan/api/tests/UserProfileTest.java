package com.veeraraghavan.api.tests;

import com.veeraraghavan.api.base.AuthenticationService;
import com.veeraraghavan.api.base.UserManagementService;
import com.veeraraghavan.api.models.request.LoginRequest;
import com.veeraraghavan.api.models.response.LoginResponse;
import com.veeraraghavan.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserProfileTest {

    @Test
    public void getUserInformation() {
        LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
        Response response = new AuthenticationService().login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserManagementService userManagementService = new UserManagementService();
        Response profileResponse = userManagementService.getUserProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = profileResponse.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getId());
        System.out.println(userProfileResponse.getUsername());
        System.out.println(userProfileResponse.getEmail());
        System.out.println(userProfileResponse.getFirstName());
        System.out.println(userProfileResponse.getLastName());
        System.out.println(userProfileResponse.getMobileNumber());
    }
}
