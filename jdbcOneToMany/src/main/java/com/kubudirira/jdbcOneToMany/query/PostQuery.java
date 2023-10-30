package com.kubudirira.jdbcOneToMany.query;

public class PostQuery {

    public static final String SELECT_POST_QUERY = "SELECT * FROM Posts";


    public static final String SELECT_POST_BY_ID_QUERY = """
                                                        SELECT id, title, content, published_on
                                                        FROM Posts
                                                        WHERE id = ?
                                                        """;

    public static final String SELECT_POST_BY_USER_ID_QUERY = """
                                                        SELECT id, title, content, published_on,user_id
                                                        FROM Posts
                                                        WHERE user_id = ?
                                                        """;
    public static final String INSERT_POST_QUERY = """
                                                    INSERT INTO Posts(title,content,published_on,user_id)
                                                    VALUES (?,?,?,?)
                                                    """;
    public static final String DELETE_POST_QUERY = "DELETE FROM Posts WHERE id = ?";

    public static final String UPDATE_POST_QUERY = """
                                                    UPDATE Posts  SET  title = ?, content = ?, published_on = ?
                                                    WHERE id = ?;
                                                    """;
}
