package com.colak.springjpatutorial.bidirectional.joincolumn.service;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Child;
import com.colak.springjpatutorial.bidirectional.joincolumn.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    @Transactional
    public Child save(Child child) {
        return childRepository.save(child);
    }

    @Transactional
    public void deleteById(Integer id) {
        childRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Child> findById(Integer id) {
        return childRepository.findById(id);
    }
}
