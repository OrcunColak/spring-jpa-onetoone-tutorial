package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.repository;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Mother;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherRepository extends JpaRepository<Mother, Integer> {
}
