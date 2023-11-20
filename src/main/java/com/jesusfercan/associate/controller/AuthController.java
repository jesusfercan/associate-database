package com.jesusfercan.associate.controller;

import com.jesusfercan.associate.dto.AuthenticationRequest;
import com.jesusfercan.associate.dto.AuthenticationResponse;
import com.jesusfercan.associate.service.impl.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.login(authRequest));
    }

    @PostMapping
    public String register(){


        return "register";
    }
}
