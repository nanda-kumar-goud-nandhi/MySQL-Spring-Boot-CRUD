package com.nanda.sqldriver.ConnectingSQL.repository;

import com.nanda.sqldriver.ConnectingSQL.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
}
