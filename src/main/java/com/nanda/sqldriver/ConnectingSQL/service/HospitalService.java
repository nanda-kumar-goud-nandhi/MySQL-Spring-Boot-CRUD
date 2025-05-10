package com.nanda.sqldriver.ConnectingSQL.service;

import com.nanda.sqldriver.ConnectingSQL.model.Hospital;

import java.util.List;

public interface HospitalService {
    String upsertHospital(Hospital hospital);

    Hospital getHospitalById(Integer hospitalId);

    List<Hospital> getAllHospitals();

    String deleteHospitalById(Integer hospitalId);
}
