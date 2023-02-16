package com.ironnestgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ironnestgym.entity.Persons;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Long>{
    
}
