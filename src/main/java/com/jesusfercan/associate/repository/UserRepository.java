package com.jesusfercan.associate.repository;

import com.jesusfercan.associate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // eliminar
    public Optional<User> findByLogin(String login);
}
