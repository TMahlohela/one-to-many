package com.kubudirira.jdbcOneToMany.controller;


import com.kubudirira.jdbcOneToMany.model.Post;
import com.kubudirira.jdbcOneToMany.model.User;
import com.kubudirira.jdbcOneToMany.repository.PostRepository;
import com.kubudirira.jdbcOneToMany.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserRepository userRepository;


    @GetMapping("/all")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public void addUser( @RequestBody User user){
        userRepository.addUser(user);
    }
    
    @PostMapping("/addPost/{id}")
    public void addPostToUser( @PathVariable("id") int user_id, @RequestBody Post post){
        userRepository.addPostToUser(user_id, post);
    }

    @PutMapping("/updateUser/{id}")
    public List<User> updateUser(@PathVariable("id") int user_id, @RequestParam String first_name, @RequestParam String last_name, @RequestParam String email) {
        userRepository.updateUser(updateUser);
    }

    @PutMapping("/updatePost/{id}")
    public List<Post> updatePostToUser(@PathVariable("id") int user_id, @RequestBody User updatedUser) {
        userRepository.updatePostToUser(user_id, post);
    }
}
