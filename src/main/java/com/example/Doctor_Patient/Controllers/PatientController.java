package com.example.Doctor_Patient.Controllers;

import com.example.Doctor_Patient.Entities.Doctor;
import com.example.Doctor_Patient.Entities.Patient;
import com.example.Doctor_Patient.Enums.City;
import com.example.Doctor_Patient.Enums.Symptom;
import com.example.Doctor_Patient.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add_patient")
    public String addPatient(@RequestBody Patient patient)
    {
        patientService.addPatient(patient);
        return "Patient added successfully";
    }

    @DeleteMapping("/delete_patient")
    public void deletePatient(@RequestParam("enter_id") int patientId)
    {
        patientService.deletePatient(patientId);

    }

    @GetMapping("/get_doctors")
    public ResponseEntity getDoctorsBasedOnPatient(@RequestParam("enter_Patient_id") int patientId) throws Exception {
        ResponseEntity ResponseEntity;
        List<Doctor> doctorList;
        try
        {
            doctorList =  patientService.getDoctorsBasedOnPatient(patientId);

        }

        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(doctorList,HttpStatus.CREATED);
    }
}
