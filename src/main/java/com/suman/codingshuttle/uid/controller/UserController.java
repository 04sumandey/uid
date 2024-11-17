package com.suman.codingshuttle.uid.controller;

import com.suman.codingshuttle.uid.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable (value = "userId",required=true)String id){
        return new UserDto("Suman","Dey");
    }
}
