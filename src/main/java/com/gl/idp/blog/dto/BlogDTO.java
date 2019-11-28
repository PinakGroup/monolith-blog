package com.gl.idp.blog.dto;

public class BlogDTO {
    private int id;
    private String description;
    private int userId;
    private boolean isApproved = false;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsApproved(boolean approved) {
        isApproved = approved;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public boolean getIsApproved() {
        return isApproved;
    }

}
