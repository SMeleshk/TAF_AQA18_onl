package models;

public class User {

    private String firstName;
    private String lastName;
    private String zipCode;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withFirstName(String value) {
            newUser.firstName = value;

            return this;
        }

        public Builder withLastName(String value) {
            newUser.lastName = value;

            return this;
        }

        public Builder withZipCode(String value) {
            newUser.zipCode = value;

            return this;
        }

        public User build() {
            return newUser;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
