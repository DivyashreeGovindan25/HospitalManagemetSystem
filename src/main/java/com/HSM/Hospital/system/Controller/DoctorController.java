package com.HSM.Hospital.system.Controller;

import com.HSM.Hospital.system.Models.Doctor;
import com.HSM.Hospital.system.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService ds;
    @GetMapping("/getDoctors")
    public List<Doctor> getDoctor(){
        return ds.getDoctor();
    }

    @PostMapping("/registerDoctor")
    public String registerDoctor(@RequestBody Doctor d){
        ds.registerDoctor(d);
        return "Doctor registered successfully";
    }
}
