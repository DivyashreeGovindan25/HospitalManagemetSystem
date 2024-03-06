package com.HSM.Hospital.system.Service;

import com.HSM.Hospital.system.Models.Doctor;
import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Models.Patient;
import com.HSM.Hospital.system.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo docRe;
    @Autowired
    HospitalService hs;
//    public DoctorService(){
//        this.docRe = new DoctorRepo();
//    }
    public List<Doctor> getDoctor(){
        return docRe.getAllgetDoctors();
    }
    public void registerDoctor(Doctor d){
        d.setDocID(UUID.randomUUID());
        Hospital h = hs.getHospital(d.getHospID());
        h.addDoctor(d);
        docRe.registerDoctor(d);
        //UUID docId = d.getHospID();
    }
    public Doctor getDoctorToAssign(){
        return docRe.getEligibleDoctor();
    }
    public void deletePatientFromDoctor(UUID pID,UUID docID){
        Doctor doc = docRe.getDoctor(docID);
        List<Patient> pList = doc.getPatients();
        for(int i=0; i<pList.size(); i++){
            Patient p = pList.get(i);
            if(Objects.equals(p.getPatientID(),pID)){
                pList.remove(i);
                return;
            }
        }
    }
}
