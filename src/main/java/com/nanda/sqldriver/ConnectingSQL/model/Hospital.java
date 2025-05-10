package com.nanda.sqldriver.ConnectingSQL.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Hospital") //Optional
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer hospitalID;

    @Column(name = "Hospital_Name")
    private String hospitalName;

    @Column(name = "Senior_Doctors_Cont")
    private Integer seniorDoctorsCount;

    @Column(name = "CEO")
    private String ceo;

}
