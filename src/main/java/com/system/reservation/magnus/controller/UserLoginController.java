package com.system.reservation.magnus.controller;

import java.util.List;

import com.system.reservation.magnus.model.User;
import com.system.reservation.magnus.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author JSBM
 */
@RestController
@RequestMapping("/api/user")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> ListUsers(){
        return userService.ListUsers();
    }

    @GetMapping("/{email}")
    public boolean existEmail (@PathVariable("email") String email) {
        return userService.existEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User authenticate(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticate(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user){
        return userService.register(user);
    }
}
