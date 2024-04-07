package com.user.service.UserService.externals.service;

import com.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating rating);


    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long ratingId, Rating rating);
}
