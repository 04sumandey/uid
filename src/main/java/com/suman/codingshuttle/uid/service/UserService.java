package com.suman.codingshuttle.uid.service;

import com.suman.codingshuttle.uid.dto.UserDto;
import com.suman.codingshuttle.uid.dto.response.UserResponse;

public interface UserService {
    UserResponse<UserDto> getUserById(long id);
}
