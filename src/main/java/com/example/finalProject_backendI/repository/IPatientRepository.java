package com.example.finalProject_backendI.repository;

import com.example.finalProject_backendI.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
