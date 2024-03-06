package com.HSM.Hospital.system.Service;

import com.HSM.Hospital.system.Models.Doctor;
import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Models.Patient;
import com.HSM.Hospital.system.Repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class HospitalService {
    @Autowired
    HospitalRepo hospRe;

//    public HospitalService(){
//        this.hospRe = new HospitalRepo();
//    }
    public List<Hospital> getHospital(){
        return hospRe.getAllHospitals();
    }
    public void registerHospital(Hospital h){
        h.setHospID(UUID.randomUUID());
        hospRe.registerHospital(h);
    }
    public Hospital getHospital(UUID hosp){
        return hospRe.getHospitalByID(hosp);
    }
    public void deletePatientFromHospital(UUID pID,UUID hospID){
        Hospital hosp = hospRe.getHospitalByID(hospID);
        List<Patient> pList = hosp.getPatients();
        for(int i=0; i<pList.size(); i++){
            Patient p = pList.get(i);
            if(Objects.equals(p.getPatientID(),pID)){
                pList.remove(i);
                return;
            }
        }
    }
    public String getHospitalName(UUID hosp){
        return hospRe.getHospitalByID(hosp).getHostName();
    }
}
