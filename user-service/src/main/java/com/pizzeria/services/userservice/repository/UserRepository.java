package com.pizzeria.services.userservice.repository;

import com.pizzeria.services.userservice.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUserType(String userType);
}
