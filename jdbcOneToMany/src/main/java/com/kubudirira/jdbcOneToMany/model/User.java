package com.kubudirira.jdbcOneToMany.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private Integer id;
    private String first_name;
    private  String last_name;
    private  String email;
    private List<Post> post;

}
