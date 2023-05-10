package com.example.Doctor_Patient.Services;

import com.example.Doctor_Patient.Entities.Doctor;
import com.example.Doctor_Patient.Entities.Patient;
import com.example.Doctor_Patient.Enums.City;
import com.example.Doctor_Patient.Enums.Speciality;
import com.example.Doctor_Patient.Enums.Symptom;
import com.example.Doctor_Patient.Repository.DoctorRepository;
import com.example.Doctor_Patient.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);

    }

    public void deletePatient(int patientId) {
        Patient patient = patientRepository.findById(patientId).get();
        patientRepository.delete(patient);

    }

    public List<Doctor> getDoctorsBasedOnPatient(int patientId) throws Exception {
        Patient patient = new Patient();
        try{
           patient  = patientRepository.findById(patientId).get();
        }
        catch(Exception e)
        {
                patient.setMessage("Patient with id " + patientId + " not found.");
                throw new RuntimeException("Patient with id " + patientId + " not found.");

        }

        List<Doctor> doctorsInCity = new ArrayList<>();
        try
        {
            //finding all the doctors with respect to the city

            List<Doctor> doctorList = doctorRepository.findAll();
            for (Doctor doctor : doctorList) {
                if (doctor.getCity().equals(patient.getCity())) {
                    doctorsInCity.add(doctor);
                }
            }
        }

     catch (Exception e)
     {
         if (doctorsInCity.isEmpty()) {
             patient.setMessage(" “We are still waiting to expand to your location” ");
             throw new RuntimeException(" “We are still waiting to expand to your location” ");
         }
     }




        //finding the doctors for patient symptoms we use doctorInCity list
        List<Doctor> suggestedDoctors = new ArrayList<>();
        try
        {
            for (Doctor doctor : doctorsInCity) {
                if (doctor.getSpeciality().equals(patient.getSymptom().getSpeciality())) {
                    suggestedDoctors.add(doctor);
                }
            }
        }
        catch (Exception e)
        {
            patient.setMessage("There isn't any doctor present at your location for your symptom.");
            throw new RuntimeException("There isn't any doctor present at your location for your symptom.");
        }


//        if (suggestedDoctors.isEmpty()) {
//            // No doctors found for the patient's symptom in their city
//            patient.setMessage("There isn't any doctor present at your location for your symptom.");
//            throw new RuntimeException("There isn't any doctor present at your location for your symptom.");
//        }

            return suggestedDoctors;

    }


}
