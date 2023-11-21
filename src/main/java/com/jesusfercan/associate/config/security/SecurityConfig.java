package com.jesusfercan.associate.config.security;

import com.jesusfercan.associate.enums.Permission;
import com.jesusfercan.associate.enums.Role;
import com.jesusfercan.associate.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .authenticationProvider(authenticationProvider)
                    .authorizeHttpRequests( auth -> auth
                            .requestMatchers("/auth/login").permitAll()
                            .requestMatchers("/user/**").hasRole(Role.ADMINISTRATOR.name())
                            .requestMatchers("/error/**").permitAll()
                            .requestMatchers("/admin/**").hasRole(Role.ADMINISTRATOR.name())
                            .requestMatchers("/associate/**").hasAuthority(Permission.READ_ALL_DATABASE.name())
                            .anyRequest().authenticated()
                );
        return http.build();
    }



    /* form login

     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
        return http.build();
    }
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").permitAll();
        return http.build();
    }
https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
     */
}