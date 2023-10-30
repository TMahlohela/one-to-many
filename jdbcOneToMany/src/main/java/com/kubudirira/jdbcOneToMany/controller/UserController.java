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
    public void addPostToUser( @PathVariable("id") int user_id,@RequestBody Post post){
         userRepository.addPostToUser(user_id, post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable Long id,
                                                @RequestParam String first_name,
                                                @RequestParam String last_name,
                                                @RequestParam String email) {
        Student updateUser = userService.updateUser(id, first_name, last_name, email);
        return ResponseEntity.ok(updateUser);

}
