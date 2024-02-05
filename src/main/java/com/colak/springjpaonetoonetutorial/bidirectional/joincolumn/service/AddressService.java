package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.service;

import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa.Address;
import com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
