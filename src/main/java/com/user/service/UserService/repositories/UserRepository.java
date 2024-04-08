package com.user.service.UserService.repositories;

import com.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
