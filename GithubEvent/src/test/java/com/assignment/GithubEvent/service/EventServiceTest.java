package com.assignment.GithubEvent.service;

import com.assignment.GithubEvent.Entity.Event;
import com.assignment.GithubEvent.Repositories.EventRepository;
import com.assignment.GithubEvent.Service.EventServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EventServiceTest {

    @Mock
    EventRepository repository;

    @InjectMocks
    EventServiceImpl service;




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

        Mockito.when(repository.save(event1)).thenReturn(event2);

        Assertions.assertEquals(1,service.saveEntity(event1).getId());

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

        Mockito.when(repository.findAll()).thenReturn(list);

        Assertions.assertEquals(service.getAllEvents().size(),2);
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

        Mockito.when(repository.findByRepoIdOrderByIdAsc(1)).thenReturn(list);

        Assertions.assertEquals(service.findByRepo(1).size(),2);
    }

    @Test
    void getByEventIdTest() throws Exception {
        Event event1 = Event.builder()
                .id(1)
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(event1));

        Assertions.assertTrue(service.findByEventId(1).isPresent());
    }



}
