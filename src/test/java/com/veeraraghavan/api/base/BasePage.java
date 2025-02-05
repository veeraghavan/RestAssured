package com.veeraraghavan.api.base;

import com.veeraraghavan.api.filters.LoggingFilters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasePage {
    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilters());
    }

    public BasePage() {
        requestSpecification = RestAssured.given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint); //jackson bind serializes java object (loginRequest in Test file LoginAPITest3) to json payload
    }

    protected void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }
}
