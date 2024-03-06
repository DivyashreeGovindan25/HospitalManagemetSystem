package com.HSM.Hospital.system.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {
    private UUID docID;
    private String name;
    private String degree;
    private List<Patient> patients;
    private UUID hospID;

    public Doctor(String name, String degree, UUID hospID) {
        this.docID = UUID.randomUUID();
        this.name = name;
        this.degree = degree;
        this.hospID = hospID;
        patients = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Patient p) {
        patients.add(p);
    }

    public UUID getDocID() {
        return docID;
    }

    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDocID(UUID docID) {
        this.docID = docID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setHospID(UUID hospID) {
        this.hospID = hospID;
    }

    public UUID getHospID() {
        return hospID;
    }
}
