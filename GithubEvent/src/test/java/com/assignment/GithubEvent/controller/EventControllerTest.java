package com.assignment.GithubEvent.controller;

import com.assignment.GithubEvent.Entity.Event;
import com.assignment.GithubEvent.Service.EventService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class EventControllerTest {

    @MockBean
    public EventService service;

    @Autowired
    public MockMvc mockMvc;

    @Test
    void saveTest() throws Exception {

        Event event1 = Event.builder()
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Event event2 = Event.builder()
                .id(1)
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Mockito.when(service.saveEntity(event1)).thenReturn(event2);

        mockMvc.perform(MockMvcRequestBuilders.post("/events").contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\"type\":\"PushEvent\",\n" +
                                "\"eventPublic\":true,\n" +
                                "\"repoId\":1,\n" +
                                "\"actorId\":1\n" +
                                "}")).andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value(event1.getType()));
    }

    @Test
    void getAllTest() throws Exception {

        Event event1 = Event.builder()
                .id(1)
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Event event2 = Event.builder()
                .id(2)
                .type("ReleaseEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);


        Mockito.when(service.getAllEvents()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/events").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].id").value(event1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(Matchers.hasSize(2)));

    }

    @Test
    void getAllByRepoTest() throws Exception {

        Event event1 = Event.builder()
                .id(1)
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Event event2 = Event.builder()
                .id(2)
                .type("ReleaseEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);


        Mockito.when(service.findByRepo(1)).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/repos/1/events").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].id").value(event1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(Matchers.hasSize(2)));

    }

    @Test
    void getByEventIdTest() throws Exception {

        Event event1 = Event.builder()
                .id(1)
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Mockito.when(service.findByEventId(1)).thenReturn(Optional.ofNullable(event1));

        mockMvc.perform(MockMvcRequestBuilders.get("/events/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(event1.getId()));

    }
}
