package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.ArrayList;
import java.util.Collection;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null)
            return null;

        final VisitTO visitTO = new VisitTO();

        // Pobierz medical treatments jako kolekcję stringów
        final Collection<MedicalTreatmentEntity> medicalTreatmentEntities = visitEntity.getMedicalTreatment();
        Collection<String> medicalTreatmentsStrings = new ArrayList<String>();
        for(MedicalTreatmentEntity entity : medicalTreatmentEntities ) {
            if(entity.getType() != null)
            {
                medicalTreatmentsStrings.add(entity.getType().toString());
            }
        }

        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctorFirstName(visitEntity.getDoctor().getFirstName());
        visitTO.setDoctorLastName(visitEntity.getDoctor().getLastName());
        visitTO.setMedicalTreatments(medicalTreatmentsStrings);

        return visitTO;
    }
}
