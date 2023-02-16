package com.ironnestgym.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironnestgym.entity.Persons;
import com.ironnestgym.repository.PersonsRepository;

@Service
public class PersonsServiceImpl implements PersonsService{
   
    
    @Autowired
    private PersonsRepository personsRepository;

    //Save operation
    @Override
    public Persons savePersons(Persons persons){
        return personsRepository.save(persons);
    }
    
    //Read operation
    @Override public List<Persons> fetchPersonsList(){
        return (List<Persons>)personsRepository.findAll();
    }

    // Update operation
    @Override
    public Persons updatePersons(Persons persons, Long personsId){

        Persons personsDB = personsRepository.findById(personsId).get();

        if (Objects.nonNull(persons.getPersonName())&& !"".equalsIgnoreCase(persons.getPersonName())) {
            personsDB.setPersonName(persons.getPersonName());
        }

        if (Objects.nonNull(persons.getPersonAddress()) && !"".equalsIgnoreCase(persons.getPersonAddress())){
            personsDB.setPersonAddress( persons.getPersonAddress());
        }

        if (Objects.nonNull(persons.getPersonCode())&& !"".equalsIgnoreCase(persons.getPersonCode())) {
            persons.setPersonCode(persons.getPersonCode());
        }

        return personsRepository.save(personsDB);
    }

     // Delete operation
     @Override
     public void deletePersonsById(Long personsId){
        personsRepository.deleteById(personsId);
     }

}
