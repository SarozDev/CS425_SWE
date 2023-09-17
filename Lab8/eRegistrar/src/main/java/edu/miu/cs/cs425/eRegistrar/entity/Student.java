package edu.miu.cs.cs425.eRegistrar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique = true)
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double cgpa;
    private String enrollmentDate;
    private String isInternational;
}
