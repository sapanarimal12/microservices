package com.user.service.UserService.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@Getter
@Setter
public class Hotel {

    private Long hotelId;

    private String name;

    private String location;

    private String about;
}
