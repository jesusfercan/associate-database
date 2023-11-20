package com.jesusfercan.associate.service;

import com.jesusfercan.associate.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User update(Long userID, User user);

    List<User> getActiveUsers();

    User getUserById(Long userId);
}
