package com.colak.springjpatutorial.bidirectional.sharedprimarykey.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")

@Getter
@Setter
public class Course {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    // Course is saved first
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private CourseDetails courseDetails;
}
