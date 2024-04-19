package com.colak.springjpatutorial.bidirectional.joincolumn.repository;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotherRepository extends JpaRepository<Mother, Integer> {

    // Custom method to get Mother by Child id
    Optional<Mother> findByChildId(Long productId);
}
