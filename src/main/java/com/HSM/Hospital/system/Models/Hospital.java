package com.HSM.Hospital.system.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hospital {
    private UUID hospID;
    private String hostName;
    private String email;
    private List<Patient> patients;
    private List<Room> rooms;
    private List<Doctor> doctors;
    private long phone;
//Hello
    public Hospital(String hostName, String email,long phone) {
        this.hospID = UUID.randomUUID();
        this.hostName = hostName;
        this.email = email;
        this.phone = phone;
        patients = new ArrayList<>();
        rooms = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor d){
        doctors.add(d);
    }
    public void addPatient(Patient p){
        patients.add(p);
    }
    public void addRoom(Room r){
        rooms.add(r);
    }
    public UUID getHospID() {
        return hospID;
    }
    public long getPhone() {
        return phone;
    }
    public String getHostName() {
        return hostName;
    }

    public String getEmail() {
        return email;
    }

    public void setHospID(UUID hospID) {
        this.hospID = hospID;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
