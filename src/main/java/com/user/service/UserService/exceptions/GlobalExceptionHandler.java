package com.user.service.UserService.exceptions;

import com.user.service.UserService.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> haldleResourceNotFoundException(ResourceNotFoundException e) {

        String message = e.getMessage();
        ApiResponse apiResponse = ApiResponse
                .builder()
                .message(message)
                .success(true)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
