package com.gl.idp.blog.service;

import com.gl.idp.blog.repository.CommentRepository;
import com.gl.idp.blog.dto.CommentDTO;
import com.gl.idp.blog.model.Blogs;
import com.gl.idp.blog.model.Comments;
import com.gl.idp.blog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final BlogService blogService;
    private final CommentRepository commentRepository;
    private final UpUserService upUserService;

    public Object save(CommentDTO commentDTO){
        Blogs blog = blogService.getById(commentDTO.getBlogId());
        User user = upUserService.getLoggedInUser();
        if(blog.isApproved()) {
            Comments comments = new Comments();
            comments.setBlogId(commentDTO.getBlogId());
            comments.setDescription(commentDTO.getDescription());
            comments.setUserId(user.getId());
            comments.setBlogByBlogId(blog);
            comments.setUserByUserId(user);
            commentRepository.save(comments);
        }
        return blogService.blogList();
    }
}
