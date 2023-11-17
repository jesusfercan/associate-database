package com.jesusfercan.associate.service.impl;

import com.jesusfercan.associate.entity.User;
import com.jesusfercan.associate.repository.UserRepository;
import com.jesusfercan.associate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository repository;


    @Override
    public User create(User user) {
        return  repository.save(user);
    }

    @Override
    public User update(User user) {
       return this.create(user);
    }
}
