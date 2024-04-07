package com.hotel.service.HotelService.controller;

import com.hotel.service.HotelService.entities.Hotel;
import com.hotel.service.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel saveHotel = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable Long hotelId) {
        Hotel Hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(Hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel() {
        List<Hotel> HotelList = hotelService.getAllHotel();
        return ResponseEntity.ok(HotelList);
    }
}
