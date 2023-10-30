package com.kubudirira.jdbcOneToMany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Integer id;
    private String title;
    private String content;
    private LocalDate published_on;

}
