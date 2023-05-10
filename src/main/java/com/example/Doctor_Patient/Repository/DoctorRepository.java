package com.example.Doctor_Patient.Repository;

import com.example.Doctor_Patient.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
