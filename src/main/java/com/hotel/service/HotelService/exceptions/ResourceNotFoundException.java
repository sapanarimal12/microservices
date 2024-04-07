package com.hotel.service.HotelService.exceptions;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Resource not found.");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
