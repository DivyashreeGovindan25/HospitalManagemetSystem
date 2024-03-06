package com.HSM.Hospital.system.Service;

import com.HSM.Hospital.system.Models.Doctor;
import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Models.Patient;
import com.HSM.Hospital.system.Models.Room;
import com.HSM.Hospital.system.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    @Autowired
    PatientRepo pr;
    @Autowired
    HospitalService hs;
    @Autowired
    DoctorService ds;
    @Autowired
    RoomService rs;
    public List<Patient> getAllPatients(){
        return pr.getAllPatients();
    }
    public List<Patient> getAllPatientsByhospID(UUID hospID){
        Hospital h = hs.getHospital(hospID);
        return h.getPatients();
    }
    public void admitPatient(Patient p){
        Hospital h = hs.getHospital(p.getHospID());
        h.addPatient(p);
        pr.admitPatient(p);
        Doctor d = ds.getDoctorToAssign();
        d.setPatients(p);
        p.setDoctor(d.getDocID());
        Room r = rs.getAllUnOccupiedRoomsByHID(h.getHospID()).get(0);
        p.setRoom(r.getRoomID());
        rs.occupy(d.getDocID(),p.getPatientID(),p.getRoomNo());
    }
    public void dischargePatient(UUID pID){
        hs.deletePatientFromHospital(pID,pr.getPatient(pID).getHospID());
        ds.deletePatientFromDoctor(pID,pr.getPatient(pID).getDoctor());
        rs.unOccupyRoom(pr.getPatient(pID).getRoomNo());
        pr.deletePatientFromPatientDB(pID);
    }
}
