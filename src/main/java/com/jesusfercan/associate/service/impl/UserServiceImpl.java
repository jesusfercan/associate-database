package com.jesusfercan.associate.service.impl;

import com.jesusfercan.associate.entity.User;
import com.jesusfercan.associate.repository.UserRepository;
import com.jesusfercan.associate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository repository;


    @Override
    public User create(User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        user.setActive(true);
        return  repository.save(user);
    }

    @Override
    public User update(Long userID, User user) {
        //User userToUpdate = repository.findById(userID).orElse(a -> new Exception(""));


        //user.setModifiedDate(LocalDateTime.now());
       return this.create(user);
    }

    @Override
    public List<User> getActiveUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found!"));
    }
}
