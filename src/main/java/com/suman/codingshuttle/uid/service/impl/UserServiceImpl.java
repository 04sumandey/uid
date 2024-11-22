package com.suman.codingshuttle.uid.service.impl;

import com.suman.codingshuttle.uid.dto.UserDto;
import com.suman.codingshuttle.uid.dto.response.ErrorResponse;
import com.suman.codingshuttle.uid.dto.response.UserResponse;
import com.suman.codingshuttle.uid.entity.UserEntity;
import com.suman.codingshuttle.uid.repository.UserRepository;
import com.suman.codingshuttle.uid.service.UserService;
import org.apache.coyote.BadRequestException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponse<UserDto> getUserById(long id) {
        try{
            if(id<1){
                throw new BadRequestException("bad request");
                }
            Optional<UserEntity> userEntityOpt= userRepository.findById(id);
            if(userEntityOpt.isEmpty()){
                throw new ResourceNotFoundException("User doesnot exit");
            }
            UserEntity userEntity = userEntityOpt.get();
            UserDto userDto = new UserDto(userEntity.getFirstName(),userEntity.getLastName());
            return new UserResponse<UserDto>(userDto );
            }catch (ResourceNotFoundException re){

            ErrorResponse errorResponse = new ErrorResponse("USER_NOT_FOUND","User doesnot exit");
            return new UserResponse<UserDto>(errorResponse);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse("BAD_REQUEST",e.getMessage());
            return new UserResponse<UserDto>(errorResponse);
        }


    }
}
