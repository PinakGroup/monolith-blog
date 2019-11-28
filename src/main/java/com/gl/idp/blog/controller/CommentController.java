package com.gl.idp.blog.controller;

import com.gl.idp.blog.service.CommentService;
import com.gl.idp.blog.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    public Object save(@RequestBody CommentDTO commentDTO){
        return commentService.save(commentDTO);
    }
}
