package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.service;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Address;
import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class AddressServiceTest {
    @Autowired
    public AddressService addressService;


    @Test
    void testSaveNullEmployee() {
        Address address = new Address();

        Address result = addressService.save(address);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertNull(result.getEmployee());
    }

    @Test
    void testSaveWithEmployee() {
        Employee employee = new Employee();
        Address address = new Address();
        address.setEmployee(employee);

        Address result = addressService.save(address);
        assertNotNull(result);
        // Address id sequence has incremented
        assertEquals(2, result.getId());

        // Employee starts with its own id sequence
        assertEquals(1, result.getEmployee().getId());
    }
}
