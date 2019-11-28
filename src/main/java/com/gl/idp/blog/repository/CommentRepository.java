package com.gl.idp.blog.repository;

import com.gl.idp.blog.model.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comments, Integer> {

}
