package com.gl.idp.blog.service;

import com.gl.idp.blog.model.Blogs;
import com.gl.idp.blog.model.User;
import com.gl.idp.blog.dto.BlogDTO;
import com.gl.idp.blog.repository.BlogRepository;
import com.gl.idp.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UpUserService upUserService;
    private final UserRepository userRepository;

    public Blogs SaveBlog(BlogDTO blogDTO){
        Blogs blog = new Blogs();
        blog.setUserId(blogDTO.getUserId());
        blog.setDescription(blogDTO.getDescription());
        blog.setApproved(false);
        blog.setUserByUserId(userRepository.findById(blogDTO.getUserId()));
        return blogRepository.save(blog);
    }

    public Object deleteBlog(BlogDTO blogDTO){
        Blogs blog = blogRepository.findById(blogDTO.getId());
        if(isMyBlog(blog) || upUserService.currentUserIsAdmin())
            blogRepository.delete(blog);
        return blogList();
    }

    public boolean isMyBlog(Blogs blog){
        User me = upUserService.getLoggedInUser();
        return blog.getUserId() == me.getId();
    }

    public Blogs getById(int blogId){
        return blogRepository.findById(blogId);
    }

    public boolean isApprovedBlog(Blogs blog){
        return blog.isApproved();
    }

    public Object blogList(){
        if(upUserService.currentUserIsAdmin())
            return blogRepository.findAll();
        User currentUser = upUserService.getLoggedInUser();
        return Stream.concat(blogRepository.findByIsApproved(true).stream(),
                blogRepository.findByUserIdAndIsApproved(currentUser.getId(), false).stream())
                .collect(Collectors.toList());
    }
}
