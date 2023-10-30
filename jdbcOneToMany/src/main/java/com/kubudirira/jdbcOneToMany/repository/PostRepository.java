package com.kubudirira.jdbcOneToMany.repository;

import com.kubudirira.jdbcOneToMany.model.Post;
import com.kubudirira.jdbcOneToMany.model.User;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    List<Post> findAll();
    List<Post>  findAllByUserId(int id);
    int addPost(Post post, int user_id);

    Optional<Post> findById(int id);
    int deletePost(int id);
    int updatePost(int id, Post post);


}
