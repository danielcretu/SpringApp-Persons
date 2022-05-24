package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return PersonService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonDetails(@PathVariable int id){
        if (PersonService.getPersonDetails(id) != null) {
            return new ResponseEntity<>(PersonService.getPersonDetails(id),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return PersonService.addPerson(person);
    }

    @PutMapping("/updatePerson/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person){
        return PersonService.updatePerson(id, person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public Person deletePerson(@PathVariable int id){
        return PersonService.deletePerson(id);
    }
}
