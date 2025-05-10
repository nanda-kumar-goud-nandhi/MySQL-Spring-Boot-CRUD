package com.nanda.sqldriver.ConnectingSQL.service;

import com.nanda.sqldriver.ConnectingSQL.model.Hospital;
import com.nanda.sqldriver.ConnectingSQL.repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    private HospitalRepo hospitalRepo;

    @Override
    public Hospital getHospitalById(Integer hospitalId) {
        Optional<Hospital> optional = hospitalRepo.findById(hospitalId);
        return optional.orElse(null);
    }

    @Override
    public String upsertHospital(Hospital hospital) {
        hospitalRepo.save(hospital);
        return "Success";
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepo.findAll();
    }

    @Override
    public String deleteHospitalById(Integer hospitalId) {
        if(hospitalRepo.existsById(hospitalId)){
            hospitalRepo.deleteById(hospitalId);
            return "Deleted Successfully";
        }
        return "No record found";
    }
}
