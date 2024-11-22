package com.suman.codingshuttle.uid.controller;

import com.suman.codingshuttle.uid.dto.UserDto;
import com.suman.codingshuttle.uid.dto.response.UserResponse;
import com.suman.codingshuttle.uid.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
//    public UserDto getUser(@PathVariable (value = "userId",required=true)String id){
//        return userService.getUserById(id);
    public ResponseEntity<UserResponse<UserDto>> getUser(@PathVariable(value = "userId",required = true)long id)throws Exception{
        UserResponse<UserDto> userResponse = userService.getUserById(id);
        if(userResponse.getIsSuccess()){
            return new ResponseEntity<UserResponse<UserDto>>(userResponse, HttpStatus.OK);
        } else if (Objects.equals(userResponse.getError().getCode(), "USER_NOT_FOUND")) {
            return new ResponseEntity<UserResponse<UserDto>>(userResponse,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<UserResponse<UserDto>>(userResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
