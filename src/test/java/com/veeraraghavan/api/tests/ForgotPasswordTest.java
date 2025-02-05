package com.veeraraghavan.api.tests;

import com.veeraraghavan.api.base.AuthenticationService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test
    public void userForgotPassword() {
        Response response = new AuthenticationService().forgotPassword("disha123@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
