package models;

public class UserGUI {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public static class Builder {
        private UserGUI newUserGUI;

        public Builder() {
            newUserGUI = new UserGUI();
        }

        public Builder withEmail(String value) {
            newUserGUI.email = value;

            return this;
        }

        public Builder withFirstName(String value) {
            newUserGUI.firstName = value;

            return this;
        }

        public Builder withLastName(String value) {
            newUserGUI.lastName = value;

            return this;
        }

        public Builder withPassword(String value) {
            newUserGUI.password = value;

            return this;
        }

        public UserGUI build() {
            return newUserGUI;
        }
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

    public String getPassword() {
        return password;
    }
}
