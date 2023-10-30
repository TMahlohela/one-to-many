package com.kubudirira.jdbcOneToMany.repository;

import com.kubudirira.jdbcOneToMany.model.Post;
import com.kubudirira.jdbcOneToMany.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();
    int addUser(User user);

    Optional<User> findById(int id);
    int deleteUser(int id);
    int updateUser(int id, User user);
    public List<User> addAllPostToUser(List<User> users);

    public void addPostToUser(int user_id, Post post);


}
