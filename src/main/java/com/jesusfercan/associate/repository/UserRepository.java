package com.jesusfercan.associate.repository;

import com.jesusfercan.associate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // eliminar
    public User findByLogin(String login);
}
