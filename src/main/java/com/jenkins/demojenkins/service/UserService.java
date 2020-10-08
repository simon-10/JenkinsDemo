package com.jenkins.demojenkins.service;


import com.jenkins.demojenkins.domain.User;
import com.jenkins.demojenkins.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(User user){
         userRepository.delete(user);
    }

    public List<User> getUserByAddress(String address){
        return userRepository.findByAddress(address);
    }


}
