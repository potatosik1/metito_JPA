package com.jpacourse.persistance.dao.impl;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public void addVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String description) {

        //TODO pozamieniaj entity managery tak jak z doctor dao

        PatientEntity patientEntity = findOne(patientId);
        if(patientEntity == null) {
            throw new EntityNotFoundException(patientId);
        }

        DoctorEntity doctorEntity = doctorDao.findOne(doctorId);
        if(doctorEntity == null) {
            throw new EntityNotFoundException(doctorId);
        }

        MedicalTreatmentEntity medicalTreatmentEntity = entityManager.find(MedicalTreatmentEntity.class, 105); // TEST
        if(medicalTreatmentEntity == null) {
            throw new EntityNotFoundException(105L);
        }

        MedicalTreatmentEntity medicalTreatmentEntity2 = entityManager.find(MedicalTreatmentEntity.class, 106); // TEST2
        if(medicalTreatmentEntity2 == null) {
            throw new EntityNotFoundException(106L);
        }

        Collection<MedicalTreatmentEntity> medicalTreatmentEntities = new ArrayList<MedicalTreatmentEntity>();
        medicalTreatmentEntities.add(medicalTreatmentEntity);
        medicalTreatmentEntities.add(medicalTreatmentEntity2);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPatient(patientEntity);
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setTime(visitDate);
        visitEntity.setDescription(description);
        visitEntity.setMedicalTreatment(medicalTreatmentEntities);

        patientEntity.getVisits().add(visitEntity);

        update(patientEntity); // Kaskadowo zapisze też wizytę
    }
}
