package com.ironnestgym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ironnestgym.entity.Persons;
import com.ironnestgym.service.PersonsService;

@RestController
public class PersonsController{
    
    @Autowired
    private PersonsService personsService;

     //Save operation
     @PostMapping("/persons/create")
     public Persons savePerson(@RequestBody Persons persons) {        
         return personsService.savePersons(persons);
     }

    // Read operation
    @GetMapping("/persons")
    public List<Persons> fetchPersonsList(){
        return personsService.fetchPersonsList();
    }

    // Update operation
    @PutMapping("/persons/{id}")
    public Persons updatePersons(@RequestBody Persons persons, @PathVariable("id") Long personsId){
       return personsService.updatePersons(persons, personsId);
    }
    
    // Delete operation
    @DeleteMapping("/persons/{id}")
    public String deletePersonsById(@PathVariable("id")Long personsId){
        personsService.deletePersonsById(personsId);
        return "Deleted Successfully";
    }
}
