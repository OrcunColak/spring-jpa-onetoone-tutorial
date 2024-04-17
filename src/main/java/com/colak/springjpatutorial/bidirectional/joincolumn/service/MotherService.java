package com.colak.springjpatutorial.bidirectional.joincolumn.service;

import com.colak.springjpatutorial.bidirectional.joincolumn.jpa.Mother;
import com.colak.springjpatutorial.bidirectional.joincolumn.repository.MotherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MotherService {

    private final MotherRepository motherRepository;

    @Transactional
    public Mother save(Mother mother) {
        return motherRepository.save(mother);
    }
}
