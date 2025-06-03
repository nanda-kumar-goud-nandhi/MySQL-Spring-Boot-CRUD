package com.nanda.sqldriver.ConnectingSQL.controller;

import com.nanda.sqldriver.ConnectingSQL.model.Hospital;
import com.nanda.sqldriver.ConnectingSQL.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HospitalControllerTest {

    @Mock
    HospitalService hospitalService;

    @InjectMocks
    HospitalController hospitalController;

    @Test
    void createHospital(){
        Hospital expectedHospital = new Hospital(1,"Test",8,"Test");
        when(hospitalService.upsertHospital(expectedHospital)).thenReturn("Successful");

        ResponseEntity<String> response = hospitalController.createHospital(expectedHospital);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Successful", response.getBody());
    }

    
}
