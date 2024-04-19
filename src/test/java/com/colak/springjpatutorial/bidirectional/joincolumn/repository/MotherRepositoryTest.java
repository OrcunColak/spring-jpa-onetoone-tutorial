package com.colak.springjpatutorial.bidirectional.joincolumn.repository;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Child;
import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MotherRepositoryTest {

    @Autowired
    private MotherRepository repository;

    @Test
    @Transactional(readOnly = true)
    void findByChildId() {
        // Child is saved first, then mother
        Mother mother = new Mother();

        Child child = new Child();

        child.setMother(mother);
        mother.setChild(child);
        repository.save(mother);

        Optional<Mother> byChildId = repository.findByChildId(1L);
        assertThat(byChildId).isPresent();
    }
}