package com.example.finalProject_backendI.repository;

import com.example.finalProject_backendI.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

    @Query("select p from patients p where p.email like %:email%")
    Set<Patient> findOnePatientByEmail(@Param("email") String email);
}
