package com.lms.demo.controller;

import com.lms.demo.data.model.User;
import com.lms.demo.data.repository.UserRepository;
import com.lms.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.UUID;

import static com.lms.demo.dto.UserDto.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST,
            produces = "application/json")
    public String createUser(@RequestBody UserDto userDto) {
        User createdUser = userRepository.save(mapUserDtoToUser(userDto));
        return createdUser.getId();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return new User(UUID.randomUUID().toString(), userDto.getName(), userDto.getDob(), userDto.getEmail(), userDto.getPassword());

    }


    @RequestMapping(value = "/Login", method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
        User existingUser = userRepository.findByAddressAndPassword(userDto.getAddress(), userDto.getPassword());
        System.out.println(userDto.getAddress());
        System.out.println(userDto.getPassword());
        if (existingUser != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
