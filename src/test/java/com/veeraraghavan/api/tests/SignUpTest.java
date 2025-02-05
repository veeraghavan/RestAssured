package com.veeraraghavan.api.tests;

import com.veeraraghavan.api.base.AuthenticationService;
import com.veeraraghavan.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void userSignupTest() {
        SignupRequest signupRequest = SignupRequest.Builder()
                .setUsername("sree1234")
                .setEmail("sree123@gmail.com")
                .setFirstName("Sree")
                .setLastName("Pandey")
                .setPassword("sree1234")
                .setMobileNumber("7777777779").build();
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.signUp(signupRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
    }
}
