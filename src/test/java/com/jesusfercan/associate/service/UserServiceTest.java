package com.jesusfercan.associate.service;

import com.jesusfercan.associate.entity.User;
import com.jesusfercan.associate.repository.UserRepository;
import com.jesusfercan.associate.service.impl.UserServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    public UserRepository repository;

    @InjectMocks
    public UserServiceImpl userService;

    @Test
    public void createUser(){
        User expected = User.builder().
                id(1).login("user").email("user@user.es").
                build();

        when(repository.save(expected)).thenReturn(expected);

        User actual = userService.create(expected);

        assertNotNull(actual);
        verify(repository,times(1)).save(expected);
    }
}
