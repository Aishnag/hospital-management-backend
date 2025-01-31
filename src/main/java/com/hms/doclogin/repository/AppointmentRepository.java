package com.hms.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppointmentRepository  extends JpaRepository<com.hms.doclogin.entity.Appointment, Long>{

}
