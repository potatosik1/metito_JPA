package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.PatientEntity;

public final class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTo = new PatientTO();
        patientEntity.setFirstName(patientEntity.getFirstName());

        // TODO: dokoncz

        return patientTo;
    }
}
