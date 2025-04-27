package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findById(@PathVariable final Long id) {
        PatientTO patient = patientService.findById(id);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/delete/{id}")
    boolean deleteById(@PathVariable final Long id) {
        PatientTO patient = patientService.findById(id);
        if(patient != null)
        {
            return patientService.deleteById(id);
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/createVisit/{patientId}+{doctorId}") // Na przyklad /102+101
    PatientTO createVisitByPatientId(@PathVariable final Long patientId, @PathVariable final Long doctorId) {
        PatientTO patient = patientService.createVisit(patientId, doctorId);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(patientId);
    }

    @GetMapping("/patient/surname/{surname}")
    PatientTO findBySurname(@PathVariable final String surname) {
        PatientTO patient = patientService.findBySurname(surname);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(404L);
    }

    @GetMapping("/patient/{id}/visits")
    Collection<VisitTO> findVisits(@PathVariable final Long id) {
        Collection<VisitTO> visits = patientService.findVisitsByPatientId(id);
        if(visits != null)
        {
            return visits;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/morethanxvisits/{amount}")
    Collection<PatientTO> findPatientsWithMoreThanXVisits(@PathVariable final Long amount) {
        Collection<PatientTO> patients = patientService.findPatientsWithMoreVisitsThanX(amount);
        if(patients != null)
        {
            return patients;
        }
        throw new EntityNotFoundException(amount);
    }

    @GetMapping("/patient/visitsafter/{date}")
    Collection<PatientTO> findPatientsWithVisitsAfterX(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        Collection<PatientTO> patients = patientService.findPatientsWithVisitsAfterX(date);
        if(patients != null)
        {
            return patients;
        }
        throw new EntityNotFoundException(404L);
    }
}
