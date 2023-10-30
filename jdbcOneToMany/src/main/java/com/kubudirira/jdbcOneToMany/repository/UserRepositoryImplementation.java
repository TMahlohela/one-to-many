package com.kubudirira.jdbcOneToMany.repository;

import com.kubudirira.jdbcOneToMany.model.Post;
import com.kubudirira.jdbcOneToMany.model.User;
import com.kubudirira.jdbcOneToMany.model.rowmapper.UserRowMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.kubudirira.jdbcOneToMany.query.UserQuery.*;



@Repository
@AllArgsConstructor
@Slf4j
public class UserRepositoryImplementation implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PostRepository postRepository;


    @Override
    public List<User> findAll() {

        List<User> users =  jdbcTemplate.query(SELECT_USER_QUERY,new UserRowMapper());
        return addAllPostToUser(users);
    }

    @Override
    public int addUser(User user) {
        return  jdbcTemplate.update(INSERT_USER_QUERY, user.getFirst_name(), user.getLast_name(), user.getEmail());
    }

    @Override
    public Optional<User> findById(int id) {
        return jdbcTemplate.query(SELECT_USER_BY_ID_QUERY,new UserRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteUser(int id) {

        return jdbcTemplate.update(DELETE_USER_QUERY,id);

    }

    @Override
    public int updateUser(int id, User user) {
        return jdbcTemplate.update(UPDATE_USER_QUERY,
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),id);
    }

    @Override
    public List<User> addAllPostToUser(List<User> users) {
        //Add posts to users.
        for (User user : users) {
            if(!postRepository.findAllByUserId(user.getId()).isEmpty()){
                user.setPost(postRepository.findAllByUserId(user.getId()));
            }

            log.info("User {}", user);
        }



        return users;
    }

    @Override
    public void addPostToUser(int user_id, Post post) {
        //Add posts to user
        postRepository.addPost(post, user_id);
    }






}
