package com.jesusfercan.associate.service.impl;

import com.jesusfercan.associate.dto.AuthenticationRequest;
import com.jesusfercan.associate.dto.AuthenticationResponse;
import com.jesusfercan.associate.entity.User;
import com.jesusfercan.associate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest request){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                request.getLogin(), request.getPassword()
        );

        authenticationManager.authenticate(authToken);

        User user = userRepository.findByLogin(request.getLogin()).get();

        String jwtToken = jwtService.generateToken(user, generateExtraClaims(user));
        return new AuthenticationResponse(jwtToken);
    }


    private Map<String,Object> generateExtraClaims(User user){
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("login",user.getLogin());
        extraClaims.put("role",user.getRole().name());
        extraClaims.put("permissions",user.getAuthorities());
        return extraClaims;
    }
}
