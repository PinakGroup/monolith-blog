package com.gl.idp.blog.controller;

import com.gl.idp.blog.service.CommentService;
import com.gl.idp.blog.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public Object save(@RequestBody CommentDTO commentDTO){
        return commentService.save(commentDTO);
    }
}
