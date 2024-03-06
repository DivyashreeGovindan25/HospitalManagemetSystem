package com.HSM.Hospital.system.Repository;

import com.HSM.Hospital.system.Models.Doctor;
import com.HSM.Hospital.system.Models.Hospital;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class DoctorRepo {
    HashMap<UUID, Doctor> docDB;

    public DoctorRepo() {
        this.docDB = new HashMap<>();
    }
    public List<Doctor> getAllgetDoctors(){
        List<Doctor> temp = new ArrayList<>();
        for(UUID i : docDB.keySet()){
            Doctor d = docDB.get(i);
            temp.add(d);
        }
        return temp;
    }
    public void registerDoctor(Doctor d){
        UUID id = d.getDocID();
        docDB.put(id,d);
    }
    public Doctor getDoctor(UUID docID){
        return docDB.get(docID);
    }
    public Doctor getEligibleDoctor(){
        int mini = Integer.MAX_VALUE;
        Doctor d = null;
        for(UUID docId : docDB.keySet()){
            if(mini > docDB.get(docId).getPatients().size()){
                mini = docDB.get(docId).getPatients().size();
                d = docDB.get(docId);
            }
        }
        return d;
    }
}
