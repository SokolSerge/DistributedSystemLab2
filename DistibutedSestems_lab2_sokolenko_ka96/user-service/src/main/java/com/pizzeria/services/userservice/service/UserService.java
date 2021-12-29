package com.pizzeria.services.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.pizzeria.services.userservice.repository.UserRepository;
import com.pizzeria.services.userservice.repository.model.User;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    public User getUserById(long id) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");
        else return maybeUser.get();
    }

    public long createUser(String email, String password, String firstName, String lastName, String userType) {
        if (!userType.equals("Client")
                && !userType.equals("Admin")
                && !userType.equals("Delivery man")
                && !userType.equals("Manager")) throw  new IllegalArgumentException("Illegal category argument");
        final User user = new User(email, password, firstName, lastName, userType);
        final User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public void updateUser(long id, String email, String password, String firstName, String lastName, String userType) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");
        User user = maybeUser.get();
        if (email != null && !email.isBlank()) user.setEmail(email);
        if (password != null && !password.isBlank()) user.setPassword(password);
        if (firstName != null && !firstName.isBlank()) user.setFirstName(firstName);
        if (lastName != null && !lastName.isBlank()) user.setLastName(lastName);
        if (userType != null && !userType.isBlank() &&(userType.equals("Client")
                || userType.equals("Admin")
                || userType.equals("Delivery man")
                || userType.equals("Manager"))) user.setUserType(userType);
        userRepository.save(user);
    }

    public void deleteUser(long id)     {
        userRepository.deleteById(id);
    }

    public List<User> getAllUserByType(String userType) {
        return userRepository.findAllByUserType(userType);
    }
}
