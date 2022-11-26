package dev.patricksilva.photoappapiusers.shared;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String fistName;
    private String lastName;
    private String userId;
    private String encryptedPassword;

    private static final long serialVersionUID = -953297098295050686L;

    // #region Getters and Setters

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    // #endregion
}
