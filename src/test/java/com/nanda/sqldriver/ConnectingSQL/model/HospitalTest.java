package com.nanda.sqldriver.ConnectingSQL.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospitalTest {

    @Test
    public void testNoArgsConstructor(){
        Hospital hospital = new Hospital();
        hospital.setHospitalID(2);
        hospital.setHospitalName("Apollo");
        hospital.setSeniorDoctorsCount(5);
        hospital.setCeo("Tarzan");
        assertEquals(hospital.getHospitalID(),2);
        assertEquals(hospital.getHospitalName(), "Apollo");
        assertEquals(hospital.getSeniorDoctorsCount(), 5);
        assertEquals(hospital.getCeo(), "Tarzan");

    }

    @Test
    public void testAllargsConstructor(){
        Hospital hospital = new Hospital(2, "Apollo", 5, "Tarzan");
        assertEquals(hospital.getHospitalID(),2);
        assertEquals(hospital.getHospitalName(), "Apollo");
        assertEquals(hospital.getSeniorDoctorsCount(), 5);
        assertEquals(hospital.getCeo(), "Tarzan");

    }
}
