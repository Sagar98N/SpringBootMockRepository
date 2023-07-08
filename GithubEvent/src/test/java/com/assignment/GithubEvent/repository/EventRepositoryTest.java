package com.assignment.GithubEvent.repository;

import com.assignment.GithubEvent.Entity.Event;
import com.assignment.GithubEvent.Repositories.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    EventRepository repository;

    @Test
    void saveTest() throws Exception {

        Event event1 = Event.builder()
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Assertions.assertNotEquals(0, repository.save(event1).getId());
    }

    @Test
    void getAllTest() throws Exception {
        Event event1 = Event.builder()
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Event event2 = Event.builder()
                .type("ReleaseEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Assertions.assertNotEquals(0,repository.save(event1).getId());

        Assertions.assertNotEquals(0,repository.save(event2).getId());

        Assertions.assertEquals(repository.findAll().size(),2);
    }

    @Test
    void getAllByRepoTest() throws Exception {
        Event event1 = Event.builder()
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Event event2 = Event.builder()
                .type("ReleaseEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Assertions.assertNotEquals(0,repository.save(event1).getId());

        Assertions.assertNotEquals(0,repository.save(event2).getId());


        Assertions.assertEquals(repository.findByRepoIdOrderByIdAsc(1).size(),2);
    }

    @Test
    void getByEventIdTest() throws Exception {

        Event event1 = Event.builder()
                .type("PushEvent")
                .eventPublic(true)
                .repoId(1)
                .actorId(1).build();

        Event event2 = repository.save(event1);

        Assertions.assertTrue(repository.findById(event2.getId()).isPresent());
    }



}
