package com.assignment.ContactManagement.repository;

import com.assignment.ContactManagement.Entity.Person;
import com.assignment.ContactManagement.Repository.ContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ContactRepositoryTest {

    Logger logger = LoggerFactory.getLogger(ContactRepositoryTest.class);

    @Autowired
    ContactRepository repository;

    @Test
    void saveEntityTest(){

        Person person = Person.builder()
                .name("Jack")
                .mobile("8887894436")
                .build();

        Person person1 = repository.save(person);

        logger.info("id is {}", person1.getId());
        Assertions.assertNotNull(person1.getId());

    }


    @Test
    void findByIdTest(){

        Person person = Person.builder()
                .name("Jack")
                .mobile("8887894436")
                .build();


        Person person1 = repository.save(person);



        Optional<Person> person2 = repository.findById(person1.getId());


        Assertions.assertTrue(person2.isPresent());
        Assertions.assertEquals(person2.get().getName(),person.getName());

    }
}
