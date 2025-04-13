package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.ArrayList;
import java.util.Collection;

public final class PatientMapper {


    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTo = new PatientTO();

        //TODO przeslij kolekcje wizyt i zmapuj wszystko tam, logika ta sama tylko zasady SOLID
        // Mapowanie wizyt w pętli
        final Collection<VisitEntity> visitsEntity = patientEntity.getVisits();
        Collection<VisitTO> visitsTO = new ArrayList<VisitTO>();
        for (final VisitEntity visitEntity : visitsEntity)
        {
            visitsTO.add(VisitMapper.mapToTO(visitEntity));
        }

        // Map patinetTo
        patientTo.setVisits(visitsTO);
        patientTo.setIsPrivateVisitor(patientEntity.getIsForeigner()); //Jeżeli pacjent jest z zagranicy to musi prywatnie

        return patientTo;
    }
}
