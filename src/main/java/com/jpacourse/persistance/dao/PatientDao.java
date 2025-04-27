package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public interface PatientDao extends Dao<PatientEntity, Long>{
    public void addVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String description);

    public PatientEntity getPatientBySurname(String surname);

    public Collection<VisitEntity> getAllVisitsByPatientId(Long patientId);

    Collection<PatientEntity> getPatientsWithMoreVisitsThanX(Long visitsAmount);

    Collection<PatientEntity> getPatientsWithVisitsAfterX(LocalDate date);
}
