package com.jpacourse.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitTO implements Serializable {
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private String medicalTreatments;

    // TODO: Napisz gettery i settery
}
