package com.veeraraghavan.api.tests;

import com.veeraraghavan.api.base.AuthenticationService;
import com.veeraraghavan.api.listeners.TestListener;
import com.veeraraghavan.api.models.request.LoginRequest;
import com.veeraraghavan.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
@Listeners(TestListener.class)
public class LoginAPITest3 {

    @Test
    public void loginTest3() {
        LoginRequest loginRequest = new LoginRequest("kholi1234", "kholi1234");
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(loginRequest); // jackson bind serializes loginRequest object to json in base page
        LoginResponse loginResponse = response.as(LoginResponse.class); //creating object for LoginResponse as LoginResponse loginResponse = new LoginResponse(). deserialization happens here
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getUsername());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getId());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getUsername(), "kholi1234");
        Assert.assertEquals(loginResponse.getEmail(), "kholi1985@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 987);
    }
}
