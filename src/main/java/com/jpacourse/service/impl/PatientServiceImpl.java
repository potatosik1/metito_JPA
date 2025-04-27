package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import com.jpacourse.persistance.enums.TreatmentType;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        PatientEntity patient = patientDao.findOne(id);
        return PatientMapper.mapToTO(patient);
    }

    @Override
    public boolean deleteById(Long id) {
        patientDao.delete(id);

        PatientEntity patient = patientDao.findOne(id);

        return patient == null;
    }

    @Override
    public PatientTO createVisit(Long patientId, Long doctorId) {
        patientDao.addVisit(patientId, doctorId, LocalDateTime.now(), "Autogenerowana wizyta");

        PatientEntity patient = patientDao.findOne(patientId);
        return PatientMapper.mapToTO(patient);
    }

    @Override
    public PatientTO findBySurname(String surname){
        PatientEntity patient = patientDao.getPatientBySurname(surname);

        return PatientMapper.mapToTO(patient);
    }

    @Override
    public Collection<VisitTO> findVisitsByPatientId(Long id){
        Collection<VisitEntity> visits = patientDao.getAllVisitsByPatientId(id);

        return VisitMapper.mapToTO(visits);
    }
}

