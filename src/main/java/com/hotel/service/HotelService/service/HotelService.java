package com.hotel.service.HotelService.service;

import com.hotel.service.HotelService.entities.Hotel;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */
public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(Long hotelId);

}
