package com.nanda.sqldriver.ConnectingSQL.service;

import com.nanda.sqldriver.ConnectingSQL.model.Hospital;
import com.nanda.sqldriver.ConnectingSQL.repository.HospitalRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceImplTest {

    @Mock
    private HospitalRepo hospitalRepo;

    @InjectMocks
    private HospitalServiceImpl hospitalService;

    @Test
    void getHospitalById_Found(){
        when(hospitalRepo.findById(2)).thenReturn(Optional.of(new Hospital(2,"Apollo",5,"Tarzan")));
        Hospital hospital = hospitalService.getHospitalById(2);
        assertEquals(2,hospital.getHospitalID());
        assertEquals("Apollo", hospital.getHospitalName());
        assertEquals(5, hospital.getSeniorDoctorsCount());
        assertEquals("Tarzan", hospital.getCeo());
        verify(hospitalRepo,times(1)).findById(2);
    }

    @Test
    void getHospitalById_NotFound(){
        when(hospitalRepo.findById(2)).thenReturn(Optional.empty());
        Hospital hospital = hospitalService.getHospitalById(2);
        assertNull(hospital);
    }

    @Test
    void upsertHospital(){
        Hospital hospital = new Hospital(2,"Apollo",5,"Tarzan");
        when(hospitalRepo.save(hospital)).thenReturn(hospital);

        String response = hospitalService.upsertHospital(hospital);
        assertEquals("Success", response);
        verify(hospitalRepo,times(1)).save(hospital);

    }

    @Test
    void getAllHospitals(){
        List<Hospital> hospitalList = new ArrayList<>(List.of(
                new Hospital(1,"test",3,"test"),
                new Hospital(2,"test2",3,"test4")
        ));
        when(hospitalRepo.findAll()).thenReturn(hospitalList);

        List<Hospital> actualHospitalList = hospitalService.getAllHospitals();
        assertEquals( 2, actualHospitalList.size());
    }

    @Test
    void deleteHospitalById_Exists(){
        when(hospitalRepo.existsById(1)).thenReturn(true);
        doNothing().when(hospitalRepo).deleteById(1);

        String response = hospitalService.deleteHospitalById(1);
        assertEquals("Deleted Successfully", response);
    }

    @Test
    void deleteHospitalById_NOt_Exists(){
        when(hospitalRepo.existsById(1)).thenReturn(false);

        String response = hospitalService.deleteHospitalById(1);
        assertEquals("No record found", response);
        verify(hospitalRepo, never()).deleteById(anyInt());
    }



}
