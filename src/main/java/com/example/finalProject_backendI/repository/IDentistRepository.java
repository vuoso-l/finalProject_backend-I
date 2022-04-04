package com.example.finalProject_backendI.repository;

import com.example.finalProject_backendI.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Integer> {
}
