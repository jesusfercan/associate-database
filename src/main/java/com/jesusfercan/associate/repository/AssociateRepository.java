package com.jesusfercan.associate.repository;

import com.jesusfercan.associate.entity.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepository extends JpaRepository<Associate,Integer> {
    //eliminar
}
