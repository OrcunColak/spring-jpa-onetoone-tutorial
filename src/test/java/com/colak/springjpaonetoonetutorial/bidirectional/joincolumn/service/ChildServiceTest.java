package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.service;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Child;
import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Mother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ChildServiceTest {
    @Autowired
    public ChildService childService;


    @Test
    void testSaveNullMother() {
        Child child = new Child();

        Child result = childService.save(child);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertNull(result.getMother());
    }

    @Test
    void testSaveWithMother() {
        Mother mother = new Mother();
        Child child = new Child();
        child.setMother(mother);

        Child result = childService.save(child);
        assertNotNull(result);
        // Child id sequence has incremented
        assertEquals(2, result.getId());

        // Mother starts with its own id sequence
        assertEquals(1, result.getMother().getId());
    }
}
