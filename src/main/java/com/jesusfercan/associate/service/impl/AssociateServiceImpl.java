package com.jesusfercan.associate.service.impl;

import com.jesusfercan.associate.entity.Associate;
import com.jesusfercan.associate.repository.AssociateRepository;
import com.jesusfercan.associate.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociateServiceImpl implements AssociateService {

    @Autowired
    public AssociateRepository repository;

    @Override
    public Associate create() {
        return null;
    }

    @Override
    public Associate update() {
        return null;
    }
}
