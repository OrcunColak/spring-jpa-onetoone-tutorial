package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.repository;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
