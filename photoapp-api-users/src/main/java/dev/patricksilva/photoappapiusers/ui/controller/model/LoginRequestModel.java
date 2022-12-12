package dev.patricksilva.photoappapiusers.ui.controller.model;

public class LoginRequestModel {
    private String email;
    private String password;

    // #region Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // #endregion
}
