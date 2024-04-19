package com.colak.springjpatutorial.bidirectional.joincolumn.repository;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotherRepository extends JpaRepository<Mother, Integer> {

    Optional<Mother> findByChildId(Long id);
}
