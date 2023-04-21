package com.rodolpho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolpho.entity.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
    
}
