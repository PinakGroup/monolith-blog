package com.gl.idp.blog.controller;

import com.gl.idp.blog.service.UpUserService;
import com.gl.idp.blog.repository.BlogRepository;
import com.gl.idp.blog.repository.RoleRepository;
import com.gl.idp.blog.repository.UserRepository;
import com.gl.idp.blog.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin
@RequestMapping(value = "/users/")
public class UserController {

    @Autowired
    UpUserService upUserService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/list")
    public Object userList(HttpServletRequest request){
        return upUserService.getAllUsers();
    }

    @PostMapping(value = "/is_unique_email")
    public Object UniqueEmailChecker(@RequestBody UserDTO userDTO){
        return upUserService.isUniqueEmail(userDTO.getEmail());
    }

    @PostMapping("/add")
    public Object save(@RequestBody UserDTO userDTO) throws Exception {
        return upUserService.saveUser(userDTO, 2);
    }

    @PostMapping("/admin/add")
    public Object saveAdmin(@RequestBody UserDTO userDTO) throws Exception {
        return upUserService.saveUser(userDTO, 1);
    }

    @PostMapping(value = "/change-approval")
    public Object changeApproval(@RequestBody UserDTO userDTO){
        return upUserService.changeApproval(userDTO);
    }

}
