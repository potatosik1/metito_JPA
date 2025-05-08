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
        long userId = 202L;
        long doctorId = 101L;

        // Act
        patientDao.delete(userId);

        // Assert
        final PatientEntity removed = patientDao.findOne(userId);
        assertThat(removed).isNull();

        final VisitEntity removedVisit = visitDao.findOne(userId);
        assertThat(removedVisit).isNull();

        final DoctorEntity notRemovedDoctor = doctorDao.findOne(doctorId);
        assertThat(notRemovedDoctor).isNotNull();
    }

    @Transactional
    @Test
    public void findById_WhenPatientIsFound_ThenReturnPatient() {
        // Arrange
        // Act
        PatientTO foundPatient = patientService.findById(202L);

        // Assert
        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getIsPrivateVisitor()).isEqualTo(false);

        VisitTO visit = foundPatient.getVisits().stream().filter(v -> v.getDoctorFirstName().equals("Magdalena")).findFirst().orElse(null);
        assertThat(visit).isNotNull();
        assertThat(visit.getDoctorFirstName()).isEqualTo("Magdalena");
        assertThat(visit.getDoctorLastName()).isEqualTo("Słomka");
        assertThat(visit.getMedicalTreatments()).contains("USG");
    }
}
