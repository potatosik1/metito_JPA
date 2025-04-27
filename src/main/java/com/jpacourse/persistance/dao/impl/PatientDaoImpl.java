package com.jpacourse.persistance.dao.impl;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.MedicalTreatmentDao;
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

    @Autowired
    private MedicalTreatmentDao medicalTreatmentDao;

    @Override
    public void addVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String description) {
        PatientEntity patientEntity = findOne(patientId);
        if(patientEntity == null) {
            throw new EntityNotFoundException(patientId);
        }

        DoctorEntity doctorEntity = doctorDao.findOne(doctorId);
        if(doctorEntity == null) {
            throw new EntityNotFoundException(doctorId);
        }

        MedicalTreatmentEntity medicalTreatmentEntity = medicalTreatmentDao.findOne(105L); // TEST
        if(medicalTreatmentEntity == null) {
            throw new EntityNotFoundException(105L);
        }

        MedicalTreatmentEntity medicalTreatmentEntity2 = medicalTreatmentDao.findOne(106L); // TEST2
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

    public PatientEntity getPatientBySurname(String surname){
        PatientEntity patient = entityManager
                .createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :param1", PatientEntity.class)
                .setParameter("param1", surname).getSingleResult();

        return patient;
    }

    public Collection<VisitEntity> getAllVisitsByPatientId(Long patientId){
        Collection<VisitEntity> visits = entityManager
                .createQuery("SELECT v FROM PatientEntity p JOIN p.visits v WHERE p.id = :param1", VisitEntity.class)
                .setParameter("param1", patientId).getResultList();

        return visits;
    }
}
