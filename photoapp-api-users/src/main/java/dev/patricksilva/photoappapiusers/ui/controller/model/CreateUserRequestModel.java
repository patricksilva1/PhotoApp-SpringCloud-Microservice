package dev.patricksilva.photoappapiusers.ui.controller.model;

public class CreateUserRequestModel {
    private String firsName;
    private String lastName;
    private String password;
    private String email;

    // #region Getters and Setters
    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // #endregion
}
