package com.gl.idp.blog.controller;

import com.gl.idp.blog.model.Blogs;
import com.gl.idp.blog.dto.BlogDTO;
import com.gl.idp.blog.repository.BlogRepository;
import com.gl.idp.blog.repository.UserRepository;
import com.gl.idp.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/blog")
@CrossOrigin
@RequiredArgsConstructor
public class BlogController {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final BlogService blogService;

    @PostMapping(value = "/add")
    public Object saveBlog(@RequestBody BlogDTO blogDTO){
        return blogService.SaveBlog(blogDTO);
    }
    @GetMapping(value = "/list_all")
    public Object list(){
        return blogService.blogList();
    }

    @PostMapping(value = "/change-approval")
    public Object changeApproval(@RequestBody BlogDTO blogDTO){
        Blogs blog = blogRepository.findById(blogDTO.getId());
        blog.setApproved(blogDTO.getIsApproved());
        blogRepository.save(blog);
        return blogService.blogList();
    }

    @PostMapping(value = "/delete")
    public Object delete(@RequestBody BlogDTO blogDTO){
        return blogService.deleteBlog(blogDTO);
    }


}
