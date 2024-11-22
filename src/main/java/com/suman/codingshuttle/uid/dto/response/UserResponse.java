package com.suman.codingshuttle.uid.dto.response;

import lombok.Data;

@Data
public class UserResponse <T>{
    Boolean isSuccess;
    T data;
    ErrorResponse error;

    public UserResponse(T data) {
        this.data = data;
        this.isSuccess = true;
    }

    public UserResponse(ErrorResponse error) {
        this.error = error;
        this.isSuccess = false;
    }
}
