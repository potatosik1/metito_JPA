package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.*;
import com.jpacourse.persistance.enums.Specialization;
import com.jpacourse.persistance.enums.TreatmentType;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void deleteById_WhenPatientIsDeleted_ThenRemoveAllVisitsButNotDoctors() {
        // Arrange
        //Doktor
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Janusz");
        doctor.setLastName("Kowalski");
        doctor.setDoctorNumber("12345");
        doctor.setEmail("doktor@email.com");
        doctor.setTelephoneNumber("1234567890");
        doctor.setSpecialization(Specialization.DERMATOLOGIST);

        //MedicalTreatment
        MedicalTreatmentEntity medicalTreatment = new MedicalTreatmentEntity();
        medicalTreatment.setDescription("opis");
        medicalTreatment.setType(TreatmentType.RTG);

        Collection<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>();
        medicalTreatments.add(medicalTreatment);

        //Visit
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription("opis");
        visitEntity.setTime(LocalDateTime.now());
        visitEntity.setMedicalTreatment(medicalTreatments);
        visitEntity.setDoctor(doctor);

        Collection<VisitEntity> visitEntities = new ArrayList<>();
        visitEntities.add(visitEntity);

        //Patient
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Jan");
        patientEntity.setLastName("Kowalski");
        patientEntity.setPatientNumber("123");
        patientEntity.setEmail("email@email.com");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity.setIsForeigner(false);
        patientEntity.setTelephoneNumber("1234567890");
        patientEntity.setVisits(visitEntities);

        // Act
        final PatientEntity saved = patientDao.save(patientEntity);
        assertThat(saved.getId()).isNotNull();
        final PatientEntity newSaved = patientDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        final VisitEntity savedVisit = visitDao.findOne(visitEntity.getId());
        assertThat(savedVisit.getId()).isNotNull();

        final DoctorEntity savedDoctor = doctorDao.findOne(doctor.getId());
        assertThat(savedDoctor.getId()).isNotNull();

        patientDao.delete(saved.getId());

        // Assert
        final PatientEntity removed = patientDao.findOne(saved.getId());
        assertThat(removed).isNull();

        final VisitEntity removedVisit = visitDao.findOne(visitEntity.getId());
        assertThat(removedVisit).isNull();

        final DoctorEntity notRemovedDoctor = doctorDao.findOne(doctor.getId());
        assertThat(notRemovedDoctor).isNotNull();
    }

    @Transactional
    @Test
    public void findById_WhenPatientIsFound_ThenReturnPatient() {
        // Arrange
        //Doktor
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Janusz");
        doctor.setLastName("Kowalski");
        doctor.setDoctorNumber("12345");
        doctor.setEmail("doktor@email.com");
        doctor.setTelephoneNumber("1234567890");
        doctor.setSpecialization(Specialization.DERMATOLOGIST);

        //MedicalTreatment
        MedicalTreatmentEntity medicalTreatment = new MedicalTreatmentEntity();
        medicalTreatment.setDescription("opis");
        medicalTreatment.setType(TreatmentType.RTG);

        Collection<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>();
        medicalTreatments.add(medicalTreatment);

        //Visit
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription("opis");
        visitEntity.setTime(LocalDateTime.now());
        visitEntity.setMedicalTreatment(medicalTreatments);
        visitEntity.setDoctor(doctor);

        Collection<VisitEntity> visitEntities = new ArrayList<>();
        visitEntities.add(visitEntity);

        //Patient
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Jan");
        patientEntity.setLastName("Kowalski");
        patientEntity.setPatientNumber("123");
        patientEntity.setEmail("email@email.com");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity.setIsForeigner(false);
        patientEntity.setTelephoneNumber("1234567890");
        patientEntity.setVisits(visitEntities);

        // Act
        final PatientEntity saved = patientDao.save(patientEntity);
        assertThat(saved.getId()).isNotNull();
        final PatientEntity newSaved = patientDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        final VisitEntity savedVisit = visitDao.findOne(visitEntity.getId());
        assertThat(savedVisit.getId()).isNotNull();

        final DoctorEntity savedDoctor = doctorDao.findOne(doctor.getId());
        assertThat(savedDoctor.getId()).isNotNull();

        PatientTO foundPatient = patientService.findById(patientEntity.getId());

        // Assert
        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getIsPrivateVisitor()).isEqualTo(patientEntity.getIsForeigner());

        VisitTO visit = foundPatient.getVisits().stream().findFirst().orElse(null);
        assertThat(visit).isNotNull();
        assertThat(visit.getDoctorFirstName()).isEqualTo(doctor.getFirstName());
    }
}
