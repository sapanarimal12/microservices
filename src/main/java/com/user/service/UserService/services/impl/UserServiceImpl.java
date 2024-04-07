package com.user.service.UserService.services.impl;

import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.entities.User;
import com.user.service.UserService.exceptions.ResourceNotFoundException;
import com.user.service.UserService.externals.service.HotelService;
import com.user.service.UserService.repositories.UserRepository;
import com.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        Rating[] ratingsOfUser = webClientBuilder.build()
                .get()                                                              // this is a method call for api get or post etc
                .uri("http://RATING-SERVICE/ratings") // url need to get access
                .retrieve()                                             // go to fetch
                .bodyToMono(Rating[].class)                             // convert the response body into class
                .block();
        logger.info(" user ratings :: {}", ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        return userList;
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found." + userId));
//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);

        Rating[] ratingsOfUser = webClientBuilder.build()
                .get()                                                              // this is a method call for api get or post etc
                .uri("http://RATING-SERVICE/ratings/users/" + user.getUserId()) // url need to get access
                .retrieve()                                             // go to fetch
                .bodyToMono(Rating[].class)                             // convert the response body into class
                .block();
        logger.info(" user ratings :: {}", ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings
                .stream()
                .map(rating -> {
//                    ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
                    Hotel hotel = hotelService.getHotel(rating.getRatingId());
                    logger.info("Hotels :: {}", hotel);
                    rating.setHotel(hotel);
                    return rating;
                })
                .collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
