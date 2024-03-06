package com.HSM.Hospital.system.Models;

import java.util.UUID;

public class Patient {
    private UUID patientID;
    private String patientName;
    private String email;
    private long phone;
    private UUID doctor;
    private String disease;
    private UUID roomNo;
    private UUID hospID;

    public Patient(String patientName, String email, long phone, String disease,UUID hospID) {
        this.patientID = UUID.randomUUID();
        this.patientName = patientName;
        this.email = email;
        this.disease = disease;
        this.phone = phone;
        this.roomNo = null;
        this.hospID = hospID;
    }

    public void setPatientID(UUID patientID) {
        this.patientID = patientID;
    }

    public UUID getHospID() {
        return hospID;
    }

    public void setHospID(UUID hospID) {
        this.hospID = hospID;
    }

    public UUID getPatientID() {
        return patientID;
    }


    public UUID getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(UUID roomNo) {
        this.roomNo = roomNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setDoctor(UUID doctor) {
        this.doctor = doctor;
    }
    public void setRoom(UUID room) {
        this.roomNo = room;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public UUID getDoctor() {
        return doctor;
    }

    public String getDisease() {
        return disease;
    }
}
