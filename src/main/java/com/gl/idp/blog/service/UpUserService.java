package com.gl.idp.blog.service;


import com.gl.idp.blog.model.CustomUserDetails;
import com.gl.idp.blog.model.User;
import com.gl.idp.blog.dto.UserDTO;
import com.gl.idp.blog.repository.RoleRepository;
import com.gl.idp.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UpUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EncryptionService encryptionService;

    public User saveUser(UserDTO userDTO, int roleId) throws Exception {
        User user = new User();
        if(roleId == 2) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        user.setEmail(userDTO.getEmail());
        user.setRoleId(roleId);
        user.setPassword(encryptionService.encrypt(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRoleByRoleId(roleRepository.findById(roleId));
        return userRepository.save(user);
    }

    public Object getAllUsers(){
        return userRepository.findAll();
    }
    public Object changeApproval(UserDTO userDTO){
        User user = userRepository.findById(userDTO.getId());
        if(user.getRoleId() == 2) {
            user.setEnabled(userDTO.getIsEnabled());
            userRepository.save(user);
        }
        return getAllUsers();
    }
    public Object isUniqueEmail(String email){
        return !userRepository.findByEmail(email).isPresent();
    }

    public User getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  (CustomUserDetails) authentication.getPrincipal();
    }

    public boolean currentUserIsAdmin(){
        return getLoggedInUser().getRoleId() == 1;
    }

    public User getByUserEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }


}
