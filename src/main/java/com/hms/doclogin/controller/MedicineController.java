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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.doclogin.entity.Medicine;
import com.hms.doclogin.repository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/v3")
public class MedicineController {
	@Autowired
	MedicineRepository mRepository;

	public MedicineController(MedicineRepository mRepository) {
		super();
		this.mRepository = mRepository;
	}

	@PostMapping("/medicines")
	public Medicine create(@RequestBody Medicine medicine) {
		return mRepository.save(medicine);
	}

	@GetMapping("/medicines")
	public List<Medicine> getAllMedicine() {
		return mRepository.findAll();

	}

	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
		Medicine medicine = mRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found By Id :" + id));
		return ResponseEntity.ok(medicine);
	}

	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> updateById(@PathVariable long id, @RequestBody Medicine medicine)
			throws AttributeNotFoundException {
		Medicine medicine1 = mRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found By Id :" + id));

		medicine1.setDrugName(medicine.getDrugName());
		medicine1.setStock(medicine.getStock());

		Medicine md = mRepository.save(medicine1);
		return ResponseEntity.ok(md);
	}

	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMedicines(@PathVariable long id)
			throws AttributeNotFoundException {
		Medicine medicine = mRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found By Id :" + id));
		mRepository.delete(medicine);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
