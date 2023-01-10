package com.sara.clinicalapis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sara.clinicalapis.model.Patient;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;

@Entity
@CrossOrigin
@Table(name = "clinicaldata")
public class ClinicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String componentName;
    private String componentValue;

    private Timestamp measuredDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;
    public int getId() {
        return id;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getComponentValue() {
        return componentValue;
    }

    public Timestamp getMeasuredDateTime() {
        return measuredDateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void setComponentValue(String componentValue) {
        this.componentValue = componentValue;
    }

    public void setMeasuredDateTime(Timestamp measuredDateTime) {
        this.measuredDateTime = measuredDateTime;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
