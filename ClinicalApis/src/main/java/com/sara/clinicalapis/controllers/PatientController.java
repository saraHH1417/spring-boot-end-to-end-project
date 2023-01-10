package com.sara.clinicalapis.controllers;

import com.sara.clinicalapis.model.ClinicalData;
import com.sara.clinicalapis.model.Patient;
import com.sara.clinicalapis.repos.PatientRepository;
import com.sara.clinicalapis.util.BMICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PatientController {

    private PatientRepository patientRepository;
    Map<String, String> filters = new HashMap<>();

    @Autowired
    PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @RequestMapping(
            value = "/patients/{id}",
            method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") int id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        }
        return null;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @RequestMapping(value = "/patients/analyze/{id}" , method =  RequestMethod.GET)
    public Patient analyze(@PathVariable("id") int id) {
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalData = patient.getClinicalDataList();
        ArrayList<ClinicalData> duplicateClinicalDate = new ArrayList<>(clinicalData);
        for (ClinicalData data: duplicateClinicalDate) {

            if (filters.containsKey(data.getComponentName())) {
                clinicalData.remove(data);
                continue;
            } else {
                filters.put(data.getComponentName(), null);
            }
            BMICalculator.calculateBMI(clinicalData, data);
        }
        filters.clear();
        return patient;
    }
}
