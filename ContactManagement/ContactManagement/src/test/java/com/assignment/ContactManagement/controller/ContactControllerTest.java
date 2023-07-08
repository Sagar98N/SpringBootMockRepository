package com.assignment.ContactManagement.controller;

import com.assignment.ContactManagement.Entity.Person;
import com.assignment.ContactManagement.Service.ContactService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest
public class ContactControllerTest {

    @MockBean
    public ContactService service;

    @Autowired
    public MockMvc mockMvc;

    @Test
    void saveTest() throws Exception {

        Person person1 = Person.builder()
                .name("Raj")
                .mobile("9899667490").build();

        Person person2 = Person.builder()
                .id(1)
                .name("Raj")
                .mobile("9899667490").build();

        Mockito.when(service.saveEntity(person1)).thenReturn(person2);

        mockMvc.perform(MockMvcRequestBuilders.post("/contact/save").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"name\":\"Raj\",\n" +
                        "\"mobile\":\"9899667490\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(person1.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mobile").value(person1.getMobile()));;

    }

    @Test
    void getByIdTest() throws Exception {

        Person person = Person.builder()
                .id(5)
                .name("Raj")
                .mobile("9899667490").build();

        Mockito.when(service.findById(5)).thenReturn(Optional.of(person));

        mockMvc.perform(MockMvcRequestBuilders.get("/contact/retrieve/5").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(person.getName()));


    }

}
