package com.example.demo.Service;

import com.example.demo.DTO.UserCreate;
import com.example.demo.DTO.UserUpdate;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User CreateUser(UserCreate user){
        User u = new User();
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setBirthday(user.getBirthday());
        return userRepository.save(u);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void DeleteUser(String id){
        userRepository.deleteById(id);
    }

    public User upDateUser(String id,UserUpdate user){
        User u = findById(id);
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setBirthday(user.getBirthday());
        return userRepository.save(u);
    }
}
