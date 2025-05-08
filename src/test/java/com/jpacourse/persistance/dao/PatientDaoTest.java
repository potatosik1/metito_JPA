package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void addVisit_WhenExecuted_AddVisitToPatient(){
        // Arrange
        long visitCount = visitDao.findAll().stream().count();

        // Act
        patientDao.addVisit(202L, 101L, LocalDateTime.now(), "TEST");

        // Assert
        PatientEntity patientEntity = patientDao.findOne(202L);
        long newVisitCount = visitDao.findAll().stream().count();

        assertThat(newVisitCount).isEqualTo(visitCount + 1);

        assertThat(patientEntity).isNotNull();
        VisitEntity visitEntity = patientEntity.getVisits().stream().filter(v -> v.getDescription().equals("TEST")).findAny().orElse(null);
        assertThat(visitEntity).isNotNull();
    }

    @Transactional
    @Test
    public void getPatientBySurname_WhenExecuted_FindPatientBySurname(){
        // Arrange
        String surname = "Nowak";

        // Act
        PatientEntity patientEntity = patientDao.getPatientBySurname(surname);

        //Assert
        assertThat(patientEntity).isNotNull();
    }

    @Transactional
    @Test
    public void getPatientsWithMoreVisitsThanX_WhenExecuted_FindPatientsWithMoreVisitsThanX(){
        // Arrange
        Long visitsAmount = 1L;

        // Act
        Collection<PatientEntity> patients = patientDao.getPatientsWithMoreVisitsThanX(visitsAmount);

        // Assert
        assertThat(patients.size()).isGreaterThan(0);
    }

    @Transactional
    @Test
    public void getPatientsWithVisitsAfterX_WhenExecuted_FindPatientsWithMoreVisitsThanX(){
        // Arrange
        LocalDate date = LocalDate.of(1999, 01, 01);

        // Act
        Collection<PatientEntity> patients = patientDao.getPatientsWithVisitsAfterX(date);

        // Assert
        assertThat(patients.size()).isGreaterThan(0);
    }
}
