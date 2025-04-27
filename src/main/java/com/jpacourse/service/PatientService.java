package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

import java.util.Collection;

public interface PatientService {
    PatientTO findById(final Long id);
    boolean deleteById(final Long id);
    PatientTO createVisit(Long patientId, Long doctorId);
    PatientTO findBySurname(String surname);
    Collection<VisitTO> findVisitsByPatientId(Long id);
}
