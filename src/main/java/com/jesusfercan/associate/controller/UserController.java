package com.jesusfercan.associate.controller;

import com.jesusfercan.associate.entity.Associate;
import com.jesusfercan.associate.service.AssociateService;
import com.jesusfercan.associate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    public UserService userService;


}
