package models;

/**
 * Created by plosco on 1/21/16.
 */
public class User {
    private String userName;
    private String password;
    private String clientID = "";
    private String clientSecret = "";

    private String accessToken = "";

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
