package com.colak.springjpatutorial.bidirectional.joincolumn.service;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Child;
import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MotherServiceTest {
    @Autowired
    private MotherService motherService;


    @Test
    void testSaveWithMother() {
        // Child is saved first, then mother
        Mother mother = new Mother();
        Child child = new Child();
        child.setMother(mother);
        mother.setChild(child);

        Mother result = motherService.save(mother);
        assertNotNull(result);
        // Mother starts with its own id sequence
        assertEquals(1, result.getId());

        // Child starts with its own id sequence
        assertEquals(1, result.getChild().getId());
    }
}
