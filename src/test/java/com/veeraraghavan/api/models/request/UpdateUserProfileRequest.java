package com.veeraraghavan.api.models.request;

public class UpdateUserProfileRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;

    private UpdateUserProfileRequest(String firstName, String lastName, String email, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String toString() {
        return "UpdateUserProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public static UpdateUserProfileRequestBuilder Builder() {
        return new UpdateUserProfileRequestBuilder();
    }

    public static class UpdateUserProfileRequestBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;

        public UpdateUserProfileRequestBuilder() {

        }

        public UpdateUserProfileRequestBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UpdateUserProfileRequestBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UpdateUserProfileRequestBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UpdateUserProfileRequestBuilder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public UpdateUserProfileRequest build() {
            return new UpdateUserProfileRequest(firstName, lastName, email, mobileNumber);
        }
    }
}
