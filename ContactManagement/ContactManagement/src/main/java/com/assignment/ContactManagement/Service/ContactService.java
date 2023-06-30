package com.assignment.ContactManagement.Service;

import com.assignment.ContactManagement.Entity.Person;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    public Person saveEntity(Person person);

    public Optional<Person> findById(int id);
}
