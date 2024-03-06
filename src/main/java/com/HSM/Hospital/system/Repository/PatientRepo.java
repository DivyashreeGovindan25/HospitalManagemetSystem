package com.HSM.Hospital.system.Repository;

import com.HSM.Hospital.system.Models.Doctor;
import com.HSM.Hospital.system.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class PatientRepo {
    HashMap<UUID, Patient> patientDB;
    public PatientRepo(){
        patientDB = new HashMap<>();
    }
    public void admitPatient(Patient p){
        UUID patientID = p.getPatientID();
        patientDB.put(patientID,p);
    }
    public Patient getPatient(UUID pID){
        return patientDB.get(pID);
    }
    public List<Patient> getAllPatients(){
        List<Patient> temp = new ArrayList<>();
        for(UUID i : patientDB.keySet()){
            Patient p = patientDB.get(i);
            temp.add(p);
        }
        return temp;
    }
    public List<Patient> getAllPatientsByhospID(UUID hospID){
        List<Patient> temp = new ArrayList<>();
        for(UUID i : patientDB.keySet()){
            Patient p = patientDB.get(i);
            if(p.getHospID() == hospID) temp.add(p);
        }
        return temp;
    }
    public void deletePatientFromPatientDB(UUID pID){
        patientDB.remove(pID);
    }
}
