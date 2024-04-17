package com.colak.springjpatutorial.bidirectional.joincolumn.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "child")

@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Child is saved first
    // mappedBy determines the owning side. The owning side is where the foreign key column lives in the database.
    // Mother is the owning side. Child can not be deleted we need to delete the mother first
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "child")
    private Mother mother;
}