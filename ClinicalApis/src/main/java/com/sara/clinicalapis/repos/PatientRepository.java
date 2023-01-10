package com.sara.clinicalapis.repos;

import com.sara.clinicalapis.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
