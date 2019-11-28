package com.gl.idp.blog.controller;

import com.gl.idp.blog.dto.LikesUnlikesDTO;
import com.gl.idp.blog.service.LikesUnlikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/likesunlikes")
public class LikesUnlikesController {

    @Autowired
    LikesUnlikesService likesUnlikesService;

    @PostMapping(value = "/add")
    public Object add(@RequestBody LikesUnlikesDTO likesUnlikesDTO){
        return likesUnlikesService.addLikesUnlikes(likesUnlikesDTO);
    }
}
