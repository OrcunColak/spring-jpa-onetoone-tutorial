package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.service;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Child;
import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;
    public Child save(Child child) {
        return childRepository.save(child);
    }
}
