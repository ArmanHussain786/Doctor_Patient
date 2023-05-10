package com.example.Doctor_Patient.Repository;

import com.example.Doctor_Patient.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
