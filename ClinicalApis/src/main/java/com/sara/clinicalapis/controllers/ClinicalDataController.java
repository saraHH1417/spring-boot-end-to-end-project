package com.sara.clinicalapis.controllers;

import com.sara.clinicalapis.dto.ClinicalDateRequest;
import com.sara.clinicalapis.model.ClinicalData;
import com.sara.clinicalapis.model.Patient;
import com.sara.clinicalapis.repos.ClinicalDataRepository;
import com.sara.clinicalapis.repos.PatientRepository;
import com.sara.clinicalapis.util.BMICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {


    private ClinicalDataRepository clinicalDataRepository;
    private PatientRepository patientRepository;

    ClinicalDataController(
            ClinicalDataRepository clinicalDataRepository,
            PatientRepository patientRepository) {
            this.clinicalDataRepository = clinicalDataRepository;
            this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/clinicals", method = RequestMethod.POST)
    public ClinicalData saveClinicalDate(
            @RequestBody ClinicalDateRequest request) {
        Patient patient= patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);
        return  clinicalDataRepository.save(clinicalData);
    }

    @RequestMapping(
            value = "/clinicals/{patientId}/{componentName}",
            method = RequestMethod.GET)
    public List<ClinicalData> getClinicalData(
            @PathVariable("patientId") int patientId,
            @PathVariable("componentName") String componentName) {

        if (componentName.equals("bmi")) {
            componentName = "hw";
        }

        List<ClinicalData> clinicalData = clinicalDataRepository
                .findByPatientIdAndComponentNameOrderByMeasuredDateTime(
                    patientId, componentName);
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
        for (ClinicalData clinicalEntry: duplicateClinicalData) {
            BMICalculator.calculateBMI(clinicalData, clinicalEntry);
        }
        return clinicalData;
    }
}
