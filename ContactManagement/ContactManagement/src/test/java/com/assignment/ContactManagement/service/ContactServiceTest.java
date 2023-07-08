package com.assignment.ContactManagement.service;

import com.assignment.ContactManagement.Entity.Person;
import com.assignment.ContactManagement.Repository.ContactRepository;
import com.assignment.ContactManagement.Service.ContactServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ContactServiceTest {

    @Mock
    ContactRepository repository;

    @InjectMocks
    ContactServiceImpl service;

    @Test
    void saveEntityTest(){
        Person person1 = Person.builder()
                .name("Drake")
                .mobile("9854678396")
                .build();

        Person person2 = Person.builder()
                .id(1)
                .name("Drake")
                .mobile("9854678396")
                .build();

        Mockito.when(repository.save(person1)).thenReturn(person2);

        Assertions.assertNotNull(service.saveEntity(person1).getId());
    }

    @Test
    void findByIdTest(){

        Person person = Person.builder()
                .id(3)
                .name("Drake")
                .mobile("9854678396")
                .build();

        Mockito.when(repository.findById(3)).thenReturn(Optional.of(person));

        Assertions.assertTrue(service.findById(3).isPresent());
    }
}
