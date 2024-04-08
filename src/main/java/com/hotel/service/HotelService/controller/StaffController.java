package com.hotel.service.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/7/2024
 */

@RestController
@RequestMapping("/staffs")
public class StaffController {


    @GetMapping
    public ResponseEntity<List<String>> getStaffs(){
        List<String> list= Arrays.asList("Ram" ,"Sita","Gita");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
