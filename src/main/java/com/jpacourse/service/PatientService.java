package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

public interface PatientService {
    PatientTO findById(final Long id);
    boolean deleteById(final Long id);
    PatientTO createVisit(Long patientId, Long doctorId);
}
