package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PatientVersioningTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void patientVersioning_WhenPatientModifiedMultipleTimes_ThenThrowOptimisticLockException(){
        // Arrange
        PatientEntity patient1 = patientDao.findOne(102L);
        PatientEntity patient2 = patientDao.findOne(102L);

        // Act
        // Modyfikujemy i zapisujemy pierwszy obiekt
        patient1.setFirstName("John");
        patientDao.update(patient1);

        // Modyfikujemy drugi obiekt
        patient2.setFirstName("Jane");

        // Assert
        assertThrows(ObjectOptimisticLockingFailureException.class, ()->{
            patientDao.update(patient2);
        });
    }
}
