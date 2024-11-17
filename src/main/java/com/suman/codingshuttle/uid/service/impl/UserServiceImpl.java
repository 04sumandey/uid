package com.suman.codingshuttle.uid.service.impl;

import com.suman.codingshuttle.uid.dto.UserDto;
import com.suman.codingshuttle.uid.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserDto getUserById(String id) {
        return new UserDto("Suman","Dey");
    }
}
