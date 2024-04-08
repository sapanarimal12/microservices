package com.rating.service.RatingService.service.impl;

import com.rating.service.RatingService.entities.Rating;
import com.rating.service.RatingService.repositories.RatingRepository;
import com.rating.service.RatingService.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    private Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);

    @Override
    public Rating create(Rating rating) {
        logger.info("User ratings :: "+ rating);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
