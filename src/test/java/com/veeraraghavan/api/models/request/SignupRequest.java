package com.veeraraghavan.api.models.request;

public class SignupRequest {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    private SignupRequest(String username, String password, String email, String firstName, String lastName, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    /*public void setUsername(String username) {
        this.username = username;
    }*/

    public String getPassword() {
        return password;
    }

    /*public void setPassword(String password) {
        this.password = password;
    }*/

    public String getEmail() {
        return email;
    }

    /*public void setEmail(String email) {
        this.email = email;
    }*/

    public String getFirstName() {
        return firstName;
    }

    /*public void setFirstName(String firstName) {
        this.firstName = firstName;
    }*/

    public String getLastName() {
        return lastName;
    }

    /*public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

    public String getMobileNumber() {
        return mobileNumber;
    }

    /*public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }*/

    @Override
    public String toString() {
        return "SignupRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public static SignupRequestBuilder Builder() {
        return new SignupRequestBuilder();
    }

    public static class SignupRequestBuilder {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;

        public SignupRequestBuilder() {

        }

        public SignupRequestBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public SignupRequestBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public SignupRequestBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public SignupRequestBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public SignupRequestBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SignupRequestBuilder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public SignupRequest build() {
            return new SignupRequest(username, password,email, firstName, lastName, mobileNumber);
        }
    }
}
