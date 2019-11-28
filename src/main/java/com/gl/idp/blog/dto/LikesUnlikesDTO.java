package com.gl.idp.blog.dto;

public class LikesUnlikesDTO {
    private int id;
    private String type;
    private int userId;
    private int blogId;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBlogId() {
        return blogId;
    }

    public String getType() {
        return type;
    }

}
