package com.colak.springjpatutorial.bidirectional.joincolumn.service;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Child;
import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ChildServiceTest {
    @Autowired
    private ChildService childService;


    @Test
    @Order(1)
    void testSaveNoMother() {
        Child child = new Child();

        Child result = childService.save(child);
        assertNotNull(result);
        // Child starts with its own id sequence
        assertEquals(1, result.getId());
        assertNull(result.getMother());
    }

    @Test
    @Order(2)
    void testSaveWithMother() {
        // Child is saved first, then mother
        Mother mother = new Mother();
        Child child = new Child();
        child.setMother(mother);
        mother.setChild(child);

        Child result = childService.save(child);
        assertNotNull(result);
        // Child starts with its own id sequence. The result is 2 because we saved on child in the previous test
        assertEquals(2, result.getId());

        // Mother starts with its own id sequence
        assertEquals(1, result.getMother().getId());
    }

    @Test
    @Order(3)
    void testDeleteWithMother() {
        // Child is saved first, then mother
        Mother mother = new Mother();
        Child child = new Child();
        child.setMother(mother);
        mother.setChild(child);

        // Mother is deleted first, then child
        Child result = childService.save(child);
        childService.deleteById(result.getId());

        Optional<Child> byId = childService.findById(result.getId());
        assertThat(byId).isEmpty();

    }
}
