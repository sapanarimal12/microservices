package com.user.service.UserService.services;

import com.user.service.UserService.entities.User;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(Long userId);
}
