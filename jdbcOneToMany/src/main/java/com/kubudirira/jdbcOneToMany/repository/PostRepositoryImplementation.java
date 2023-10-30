package com.kubudirira.jdbcOneToMany.repository;

import com.kubudirira.jdbcOneToMany.model.Post;
import com.kubudirira.jdbcOneToMany.model.User;
import com.kubudirira.jdbcOneToMany.model.rowmapper.PostRowMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.kubudirira.jdbcOneToMany.query.PostQuery.*;


@Repository
@AllArgsConstructor
@Slf4j
public class PostRepositoryImplementation implements PostRepository{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Post> findAll() {

        return jdbcTemplate.query(SELECT_POST_QUERY,new PostRowMapper());
    }

    @Override
    public List<Post> findAllByUserId(int user_id) {

        return jdbcTemplate.query(SELECT_POST_BY_USER_ID_QUERY,new PostRowMapper(),user_id).stream().toList();


    }

    @Override
    public int addPost(Post post,int user_id) {
        return jdbcTemplate.update(INSERT_POST_QUERY, post.getTitle(),post.getContent(), post.getPublished_on(),user_id);
    }

    @Override
    public Optional<Post> findById(int id) {
        return jdbcTemplate.query(SELECT_POST_BY_ID_QUERY,new PostRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int deletePost(int id) {
        return jdbcTemplate.update(DELETE_POST_QUERY,id);
    }


    @Override
    public int updatePost(int id, Post post) {
        return jdbcTemplate.update(UPDATE_POST_QUERY,
                post.getTitle(),
                post.getContent(),
                post.getPublished_on(),id);
    }
}
