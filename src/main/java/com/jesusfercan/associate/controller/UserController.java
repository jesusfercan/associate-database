package com.jesusfercan.associate.controller;

import com.jesusfercan.associate.entity.Associate;
import com.jesusfercan.associate.entity.User;
import com.jesusfercan.associate.service.AssociateService;
import com.jesusfercan.associate.service.UserService;
import com.jesusfercan.associate.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getActiveUsers()
        );
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userService.create(user)
        );

    }

    @PutMapping("/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable Long userID, @RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                userService.update(userID,user)
        );
    }
    @GetMapping("/{userID}")
    public ResponseEntity<User> getUser(@PathVariable Long userID){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getUserById(userID)
        );
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@PathVariable Long userID){
        return null;
    }

}
