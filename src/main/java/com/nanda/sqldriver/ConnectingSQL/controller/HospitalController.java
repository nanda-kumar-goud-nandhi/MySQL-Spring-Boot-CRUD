package com.nanda.sqldriver.ConnectingSQL.controller;

import com.nanda.sqldriver.ConnectingSQL.model.Hospital;
import com.nanda.sqldriver.ConnectingSQL.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/hospital")
    public String greeting(){
        return "Welcome to Hospital";
    }

    @PostMapping("/hospital")
    public ResponseEntity<String> createHospital(@RequestBody Hospital hospital){
        String status = hospitalService.upsertHospital(hospital);
        return new ResponseEntity<>(status, HttpStatus.CREATED);

    }

    @PutMapping("/hospital")
    public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital){
        String status = hospitalService.upsertHospital(hospital);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Integer hospitalId){
        Hospital hospital = hospitalService.getHospitalById(hospitalId);
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }

    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        List<Hospital> hospitalList = hospitalService.getAllHospitals();
        return new ResponseEntity<>(hospitalList,HttpStatus.OK);
    }

    @DeleteMapping("/hospital/{hospitalId}")
    public ResponseEntity<String> deleteHospital(@PathVariable Integer hospitalId){
        String status = hospitalService.deleteHospitalById(hospitalId);
        if(status.equals("Deleted Successfully")){
            return new ResponseEntity<>(status,HttpStatus.OK);
        }
        return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
   }
}
