package com.gl.idp.blog.repository;


import com.gl.idp.blog.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findById(int roleId);
}
