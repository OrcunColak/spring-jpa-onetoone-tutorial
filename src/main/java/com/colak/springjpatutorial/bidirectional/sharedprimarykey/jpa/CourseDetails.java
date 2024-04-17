package com.colak.springjpatutorial.bidirectional.sharedprimarykey.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course_details")

@Getter
@Setter
public class CourseDetails {

    // Don’t use @GeneratedValue(strategy = GenerationType.IDENTITY) with @Id because we don’t need to generate an ID for CourseDetails
    @Id
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Course course;
}
