package com.kubudirira.jdbcOneToMany.model.rowmapper;

import com.kubudirira.jdbcOneToMany.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PostRowMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Post(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getDate("published_on").toLocalDate()
                );
    }
}
