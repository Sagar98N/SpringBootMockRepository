package com.assignment.ContactManagement.Controller;

import com.assignment.ContactManagement.Entity.Person;
import com.assignment.ContactManagement.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person){
        Person person1 = contactService.saveEntity(person);
        return  new ResponseEntity<>(person1, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<Optional<Person>> getAllByEvent(@PathVariable int id){
        Optional<Person> person = contactService.findById(id);
        if(person.isPresent()){
            return  new ResponseEntity<>(person, HttpStatusCode.valueOf(200));
        }

        return new ResponseEntity<>(HttpStatusCode.valueOf(404));

    }
}
