package com.HSM.Hospital.system.Controller;

import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Service.HospitalService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(HospitalController.class);
    @Autowired
    HospitalService hs;

    @GetMapping("/getHospitals")
    public List<Hospital> getHospital(){
        return hs.getHospital();
    }

    @PostMapping("/registerHospital")
    public String registerHospital(@RequestBody Hospital h){
        hs.registerHospital(h);
        logger.debug("A new Hospital is registered debug");
        logger.info("A new Hospital is registered info");
        return "Hospital registered successfully";
    }
    @GetMapping("")
    public Hospital getHospId(@RequestParam UUID h){
        return hs.getHospital(h);
    }

}
