package com.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;
    private Long userId;
    private Long hotelId;
    private Long rating;
    private String feedback;
    private Hotel hotel;

}
