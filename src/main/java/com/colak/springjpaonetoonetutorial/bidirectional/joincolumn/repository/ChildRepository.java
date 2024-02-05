package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.repository;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Integer> {
}
