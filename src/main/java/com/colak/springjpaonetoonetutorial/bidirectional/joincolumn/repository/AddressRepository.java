package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.repository;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
