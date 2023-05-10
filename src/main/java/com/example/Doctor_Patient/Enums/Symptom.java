package com.example.Doctor_Patient.Enums;

import com.example.Doctor_Patient.Enums.Speciality;

public enum Symptom {
    ARTHRITIS(Speciality.ORTHOPEDIC),
    BACKPAIN(Speciality.ORTHOPEDIC),
    TISSUE_INJURIES(Speciality.ORTHOPEDIC),
    DYSMENORRHEA(Speciality.GYNECOLOGY),
    SKIN_INFECTION(Speciality.DERMATOLOGY),
    SKIN_BURN(Speciality.DERMATOLOGY),
    EAR_PAIN(Speciality.ENT_SPECIALIST);

    private final Speciality speciality;

    Symptom(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}

//Arthritis, Backpain, Tissue injuries (comes under Orthopedic speciality)
//        Dysmenorrhea (comes under Gynecology speciality)
//        Skin infection, skin burn (comes under Dermatology speciality)
//        Ear pain (comes under ENT speciality)
