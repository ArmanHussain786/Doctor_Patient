package com.example.Doctor_Patient.Controllers;

import com.example.Doctor_Patient.Entities.Doctor;
import com.example.Doctor_Patient.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add_doctor")
    public String addDoctor(@RequestBody Doctor doctor)
    {
        doctorService.addDoctor(doctor);
        return "Doctor added";
    }

    @DeleteMapping("/delete_doctor")
    public String deleteDoctor(@RequestParam int doctorId)
    {
        doctorService.deleteDoctor(doctorId);
        return "doctor deleted";
    }
}
