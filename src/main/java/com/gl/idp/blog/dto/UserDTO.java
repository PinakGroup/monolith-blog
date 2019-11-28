package com.gl.idp.blog.dto;

public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int roleId;
    private String password;
    private String token;
    private boolean isEnabled;

    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIsEnabled(boolean enabled) {
        isEnabled = enabled;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getId() {
        return id;
    }
    public int getRoleId() {
        return roleId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getLastName() {
        return lastName;
    }
    public String getToken() {
        return token;
    }
    public boolean getIsEnabled(){
        return isEnabled;
    }
}
