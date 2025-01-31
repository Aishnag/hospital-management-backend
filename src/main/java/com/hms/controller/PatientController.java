package com.hms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Patient;
import com.hms.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
	@Autowired
	PatientRepository paRepository;

	public PatientController(PatientRepository paRepository) {
		super();
		this.paRepository = paRepository;
	}

	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return paRepository.save(patient);
	}

	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return paRepository.findAll();
	}

	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException {
		Patient patient1 = paRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Patient is not found by Id :" + id));
		return ResponseEntity.ok(patient1);
	}

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatients(@PathVariable long id)
			throws AttributeNotFoundException {
		Patient patient = paRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("patient not found by id: " + id));
		paRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updateById(@PathVariable long id, @RequestBody Patient patient)
			throws AttributeNotFoundException {
		Patient patient2 = paRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("patient not found by id: " + id));

		patient2.setAge(patient.getAge());
		patient2.setBlood(patient.getBlood());
		patient2.setDose(patient.getDose());
		patient2.setFees(patient.getFees());
		patient2.setFirst_name(patient.getFirst_name());
		patient2.setPrescipstion(patient.getPrescipstion());
		patient2.setUrgency(patient.getUrgency());

		Patient pp = paRepository.save(patient2);

		return ResponseEntity.ok(pp);

	}

}
