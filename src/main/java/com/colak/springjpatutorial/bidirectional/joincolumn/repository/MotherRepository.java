package com.colak.springjpatutorial.bidirectional.joincolumn.repository;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherRepository extends JpaRepository<Mother, Integer> {
}
