package com.jesusfercan.associate.controller;

import com.jesusfercan.associate.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AssociateController {

    @Autowired
    public AssociateService associateService;
}
