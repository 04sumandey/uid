package com.suman.codingshuttle.uid.controller;

import com.suman.codingshuttle.uid.dto.UserDto;
import com.suman.codingshuttle.uid.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable (value = "userId",required=true)String id){
        return userService.getUserById(id);
    }
}
