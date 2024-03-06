package com.HSM.Hospital.system.Controller;

import com.HSM.Hospital.system.Models.Patient;
import com.HSM.Hospital.system.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Patients")
public class PatientController {
    @Autowired
    PatientService ps;
    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
        return ps.getAllPatients();
    }
    @GetMapping("")
    public List<Patient> getAllPatientsByID(@RequestParam UUID hospID){
        return ps.getAllPatientsByhospID(hospID);
    }
    @DeleteMapping("/{pID}/DischargePatient")
    public String dischargePatient(@PathVariable UUID pID){
        ps.dischargePatient(pID);
        return "Patient Discharged";
    }
    @PostMapping("/registerPatient")
    public String registerPatients(@RequestBody Patient p){
        ps.admitPatient(p);
        return "Patient admitted";
    }
}
