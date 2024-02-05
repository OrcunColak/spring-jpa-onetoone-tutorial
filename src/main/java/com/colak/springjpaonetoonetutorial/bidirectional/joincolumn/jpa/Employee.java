package com.colak.springjpaonetoonetutorial.bidirectional.joincolumn.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "employee")
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * employee table: addrs_id column is foreign key for address table : id column
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addrs_id", referencedColumnName = "id")
    private Address address;
}
