package com.gl.idp.blog.service;

import com.gl.idp.blog.repository.BlogRepository;
import com.gl.idp.blog.repository.LikesUnlikesRepository;
import com.gl.idp.blog.repository.UserRepository;
import com.gl.idp.blog.dto.LikesUnlikesDTO;
import com.gl.idp.blog.model.Blogs;
import com.gl.idp.blog.model.LikesUnlikes;
import com.gl.idp.blog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesUnlikesService {

    private final LikesUnlikesRepository likesUnlikesRepository;
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    public Object addLikesUnlikes(LikesUnlikesDTO likesUnlikesDTO){

        int blogId = likesUnlikesDTO.getBlogId();

        if(blogService.getById(blogId) != null){

            Blogs blog = blogService.getById(blogId);

            if(blogService.isApprovedBlog(blog) && ! blogService.isMyBlog(blog)) {

                int userId = likesUnlikesDTO.getUserId();
                String type = likesUnlikesDTO.getType();
                LikesUnlikes likesUnlikes = null;

                try {
                    likesUnlikes = likesUnlikesRepository.findByUserIdAndBlogIdAndType(userId, blogId, type);
                } catch (Exception e) {
                }

                if (likesUnlikes == null) {
                    User user = userRepository.findById(userId);
                    likesUnlikes = getLikesUnlikesEntityFromDTO(likesUnlikesDTO, blog, user);
                    likesUnlikesRepository.save(likesUnlikes);

                    LikesUnlikes alternativeLikesUnlikes = null;

                    String alternateType = "ul";
                    if(likesUnlikesDTO.getType().equals("ul"))
                        alternateType = "l";

                    try {
                        alternativeLikesUnlikes = likesUnlikesRepository.findByUserIdAndBlogIdAndType(userId, blogId, alternateType);
                    } catch (Exception e) {
                    }

                    if(alternativeLikesUnlikes != null){
                        likesUnlikesRepository.delete(alternativeLikesUnlikes);
                    }

                }

            }

        }

        return blogService.blogList();
    }

    public LikesUnlikes getLikesUnlikesEntityFromDTO(LikesUnlikesDTO likesUnlikesDTO, Blogs blog, User user){
        LikesUnlikes likesUnlikes = new LikesUnlikes();
        likesUnlikes.setBlogId(likesUnlikesDTO.getBlogId());
        likesUnlikes.setUserId(likesUnlikesDTO.getUserId());
        likesUnlikes.setType(likesUnlikesDTO.getType());
        likesUnlikes.setBlogByBlogId(blog);
        likesUnlikes.setUserByUserId(user);
        return likesUnlikes;
    }
}
