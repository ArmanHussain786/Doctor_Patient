package com.example.Doctor_Patient.Services;

import com.example.Doctor_Patient.Entities.Doctor;
import com.example.Doctor_Patient.Repository.DoctorRepository;
import com.example.Doctor_Patient.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);

    }

    public void deleteDoctor(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        doctorRepository.delete(doctor);

    }
}
