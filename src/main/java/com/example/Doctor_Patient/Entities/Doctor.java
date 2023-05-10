package com.example.Doctor_Patient.Entities;

import com.example.Doctor_Patient.Enums.City;
import com.example.Doctor_Patient.Enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   //doctor have some unique id  for acting as a primary key

    @Size(min = 3)  //Name (should be at least 3 characters)
    private String name;


    @Enumerated(EnumType.STRING)
    private City city;


    private String email;

    @Size(min = 10)   // phone should have at-least 10 numbers
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

//    @ManyToOne
//    @JoinColumn
//    private Patient patient;
}
