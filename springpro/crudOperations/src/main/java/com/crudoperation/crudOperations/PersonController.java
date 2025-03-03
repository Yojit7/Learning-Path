package com.crudoperation.crudOperations;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crudoperation.crudOperations.exceptions.PersonNotFoundException;



@RestController
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    @PostMapping("/createPerson")
    public ResponseEntity<Person> createName(@RequestBody Person person)  {
        Person response =personRepo.save(person);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/Persons")
    public List<Person> getAllPerson () {
        List<Person> personList=personRepo.findAll();
        return personList;
    }
    
    @GetMapping("/personById/{myId}")
    public Person getPerson(@PathVariable("myId") Long myId) {
        Person personbyId = personRepo.findById(myId).orElseThrow(()-> new PersonNotFoundException("Person Not Found") );
        return personbyId;

    }

    @PutMapping("/updatePerson/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person updatePerson) {
        Person existPerson = personRepo.findById(id).orElse(null);
        if(existPerson != null){
            existPerson.setName(updatePerson.getName());
            existPerson.setEmail(updatePerson.getEmail());
            personRepo.save(existPerson);
            return existPerson;

        }else{
            return null;

        }
    }


    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") Long id){
        personRepo.deleteById(id);
        return "Person is deleted successfully";
    }


    @ExceptionHandler
    public String handleException(PersonNotFoundException exception){
        return "Person not Found";
    }


}
