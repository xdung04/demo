package com.example.demo.Controller;

import com.example.demo.DTO.UserCreate;
import com.example.demo.DTO.UserUpdate;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    User CreateUser(@RequestBody UserCreate user) {
        return userService.CreateUser(user);
    }
    @GetMapping
    List<User> GetAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/{userid}")
    User GetUserById(@PathVariable String userid) {
        return userService.findById(userid);
    }

    @PutMapping("/{userid}")
    User UpdateUser(@PathVariable String userid, @RequestBody UserUpdate user) {
        return userService.upDateUser(userid,user);
    }
    @DeleteMapping("/{userid}")
    String DeleteUser(@PathVariable String userid) {
        userService.DeleteUser(userid);
        return "User has been deleted";
    }
}
