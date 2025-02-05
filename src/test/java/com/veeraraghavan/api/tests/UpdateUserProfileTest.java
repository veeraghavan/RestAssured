package com.veeraraghavan.api.tests;

import com.veeraraghavan.api.base.AuthenticationService;
import com.veeraraghavan.api.base.UserManagementService;
import com.veeraraghavan.api.listeners.TestListener;
import com.veeraraghavan.api.models.request.LoginRequest;
import com.veeraraghavan.api.models.request.UpdateUserProfileRequest;
import com.veeraraghavan.api.models.response.LoginResponse;
import com.veeraraghavan.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class UpdateUserProfileTest {

    @Test (description = "Update the user information....")
    public void updateUserInformation() {
        System.out.println("************************** LOGIN ****************************************");
        /** Login to the portal **/
        LoginRequest loginRequest = new LoginRequest("veera1234", "veera1234");
        AuthenticationService authenticationService = new AuthenticationService();
        Response responseLogin = authenticationService.login(loginRequest);
        System.out.println(responseLogin.asPrettyString());
        LoginResponse loginResponse = responseLogin.as(LoginResponse.class);
        String userToken = loginResponse.getToken();
        System.out.println(userToken);

        System.out.println("************************** GET PROFILE ****************************************");
        /** Get the profile information **/
        UserManagementService userManagementService = new UserManagementService();
        Response responseGetProfile = userManagementService.getUserProfile(userToken);
        UserProfileResponse userProfileResponse = responseGetProfile.as(UserProfileResponse.class);
        System.out.println(responseGetProfile.asPrettyString());
        System.out.println("Default First Name :::: " + userProfileResponse.getFirstName());
        System.out.println("Default Last Name :::: " + userProfileResponse.getLastName());

        System.out.println("**************************** UPDATE PROFILE **************************************");
        /** Update the profile information **/
        UpdateUserProfileRequest updateUserProfileRequest = UpdateUserProfileRequest.Builder()
                .setFirstName("Angelina")
                .setLastName("Jolie")
                .setEmail("angelinajolie@gmail.com")
                .setMobileNumber("8888888882").build();
        Response responseUpdateProfile = userManagementService.updateUserProfile(updateUserProfileRequest, userToken);
        userProfileResponse = responseUpdateProfile.as(UserProfileResponse.class);
        System.out.println(responseUpdateProfile.asPrettyString());
        System.out.println("Modified First Name :::: " + userProfileResponse.getFirstName());
        System.out.println("Modified Last Name :::: " + userProfileResponse.getLastName());
    }
}
