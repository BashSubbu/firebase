package com.yal.pushnotifications.controller;

import com.yal.pushnotifications.entity.Person;
import com.yal.pushnotifications.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
@RestController
public class MainController {
    @Autowired
    PersonService personService;

    @GetMapping("/getPatientDetails")
    public Person getPatient(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return personService.getPersonDetails(name);
    }

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody Person person ) throws InterruptedException, ExecutionException {
        return personService.savePersonDetails(person);
    }

    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Person person) throws InterruptedException, ExecutionException {
        return personService.updatePersonDetails(person);
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam String name){
        return personService.deletePerson(name);
    }
}
