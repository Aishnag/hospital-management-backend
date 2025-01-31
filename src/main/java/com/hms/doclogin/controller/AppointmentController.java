package com.hms.doclogin.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.doclogin.entity.Appointment;
import com.hms.doclogin.repository.AppointmentRepository;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/v2")
public class AppointmentController {
	@Autowired
	AppointmentRepository aRepository;

	public AppointmentController(AppointmentRepository aRepository) {
		super();
		this.aRepository = aRepository;
	}

	@PostMapping("/appointments") // to create appointment
	public Appointment createAppiontment(@RequestBody Appointment appointment) {
		return aRepository.save(appointment);
	}

	@GetMapping("/appointments") // find all appointment
	public List<Appointment> getAllAppointments() {
		return aRepository.findAll();

	}
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteAppoinment(@PathVariable long id) throws AttributeNotFoundException{
		Appointment appointment=aRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("appointment not found with id: "+id));
		aRepository.delete(appointment);
		Map<String,Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
