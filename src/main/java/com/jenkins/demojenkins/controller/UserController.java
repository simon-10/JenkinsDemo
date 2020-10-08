package com.jenkins.demojenkins.controller;

import com.jenkins.demojenkins.domain.User;
import com.jenkins.demojenkins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUSer(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getusers")
    public List<User>  findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUserByAddress/{address}")
    public List<User> findUserByAddress(@PathVariable String address){
        return userService.getUserByAddress(address);
    }

    @DeleteMapping("/remove")
    public User removeUser(@RequestBody User user){
        userService.deleteUser(user);
        return user;
    }

}
