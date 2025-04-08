package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // Relacja @ManyToOne dwukierunkowe od strony dziecka
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctor;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // Relacja @ManyToOne dwukierunkowa, od strony rodzica
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patient;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // Relacja @OneToMany dwukierunkowa od strony dziecka
	private Collection<MedicalTreatmentEntity> medicalTreatment; //jako liste stringow w zadaniu 2

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatment() {
		return medicalTreatment;
	}

	public void setMedicalTreatment(Collection<MedicalTreatmentEntity> medicalTreatment)
	{
		this.medicalTreatment = medicalTreatment;
	}
}
