package com.HSM.Hospital.system.Repository;

import com.HSM.Hospital.system.Models.Hospital;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class HospitalRepo {
    HashMap<UUID, Hospital> hospDB;

    public HospitalRepo() {
        this.hospDB = new HashMap<>();
    }
    public List<Hospital> getAllHospitals(){
        List<Hospital> temp = new ArrayList<>();
        for(UUID i : hospDB.keySet()){
            Hospital h = hospDB.get(i);
            temp.add(h);
        }
        return temp;
    }
    public void registerHospital(Hospital h){
        UUID id = h.getHospID();
        hospDB.put(id,h);
    }
    public Hospital getHospitalByID(UUID hospID){
        return hospDB.get(hospID);
    }
}
