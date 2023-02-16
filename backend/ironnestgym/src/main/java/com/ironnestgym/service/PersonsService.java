package com.ironnestgym.service;

import java.util.List;

import com.ironnestgym.entity.Persons;

public interface PersonsService {
    
     //Save operation
     Persons savePersons(Persons person);

     //Read operation
     List<Persons> fetchPersonsList();
 
     //Update operation
     Persons updatePersons(Persons person, Long personId);
 
     //Delete operation
     void deletePersonsById(Long personId);

}
