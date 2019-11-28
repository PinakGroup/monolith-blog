package com.gl.idp.blog.dto;

public class CommentDTO {
    int id;
    int userId;
    int blogId;
    String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getDescription() {
        return description;
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
}
