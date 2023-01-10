package com.sara.clinicalapis.dto;

public class ClinicalDateRequest {
    private String componentName;
    private String componentValue;
    private int patientId;

    public String getComponentName() {
        return componentName;
    }

    public String getComponentValue() {
        return componentValue;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void setComponentValue(String componentValue) {
        this.componentValue = componentValue;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
