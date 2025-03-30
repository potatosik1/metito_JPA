package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

public interface PatientService {
    PatientTO findById(final Long id);
    boolean deleteById(final Long id);
}
