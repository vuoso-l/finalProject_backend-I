package com.example.finalProject_backendI.repository;

import com.example.finalProject_backendI.entity.DentistShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistShiftRepository extends JpaRepository<DentistShift, Integer> {
}
