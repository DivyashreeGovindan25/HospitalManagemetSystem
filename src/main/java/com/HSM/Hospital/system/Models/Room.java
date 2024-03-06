package com.HSM.Hospital.system.Models;

import java.util.List;
import java.util.UUID;

public class Room {
    private UUID roomID;
    private UUID doctor;
    private UUID patient;
    private UUID hospitalID;
    private boolean isOccupied;

    public Room(UUID hospitalID, boolean isOccupied) {
        this.roomID = UUID.randomUUID();
        this.isOccupied = isOccupied;
        this.hospitalID = hospitalID;
    }

    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID roomID) {
        this.roomID = roomID;
    }

    public void setDoctor(UUID doctor) {
        this.doctor = doctor;
    }

    public void setPatient(UUID patient) {
        this.patient = patient;
    }

    public UUID getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(UUID hospitalID) {
        this.hospitalID = hospitalID;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public UUID getDoctor() {
        return doctor;
    }

    public UUID getPatient() {
        return patient;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
