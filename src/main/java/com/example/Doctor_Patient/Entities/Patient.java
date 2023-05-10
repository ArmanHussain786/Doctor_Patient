package com.example.Doctor_Patient.Entities;

import com.example.Doctor_Patient.Enums.City;
import com.example.Doctor_Patient.Enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Size(min = 3)
   private String patientName;

   @Enumerated(EnumType.STRING)
   private City city;


   private String email;

   @Size(min = 10)
   private String phoneNumber;

   @Enumerated(EnumType.STRING)
   private Symptom symptom;

   private String message;

//    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
//    private List<Doctor> doctorList = new ArrayList<>();
}








