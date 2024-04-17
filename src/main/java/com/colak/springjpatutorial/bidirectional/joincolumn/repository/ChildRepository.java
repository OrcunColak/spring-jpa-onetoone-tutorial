package com.colak.springjpatutorial.bidirectional.joincolumn.repository;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Integer> {
}
