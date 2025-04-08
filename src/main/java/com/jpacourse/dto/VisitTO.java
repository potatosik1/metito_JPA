package com.jpacourse.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

public class VisitTO implements Serializable {
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private Collection<String> medicalTreatments;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public Collection<String> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(Collection<String> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }
}
