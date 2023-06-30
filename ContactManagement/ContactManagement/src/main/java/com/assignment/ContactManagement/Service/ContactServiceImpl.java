package com.assignment.ContactManagement.Service;

import com.assignment.ContactManagement.Entity.Person;
import com.assignment.ContactManagement.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements  ContactService{

    @Autowired
    ContactRepository contactRepository;


    @Override
    public Person saveEntity(Person person) {
        return contactRepository.save(person);
    }

    @Override
    public Optional<Person> findById(int id) {
        return contactRepository.findById(id);
    }
}

