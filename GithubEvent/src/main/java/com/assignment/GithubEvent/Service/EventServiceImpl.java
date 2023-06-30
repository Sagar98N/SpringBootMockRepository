package com.assignment.GithubEvent.Service;

import com.assignment.GithubEvent.Entity.Event;
import com.assignment.GithubEvent.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;
    @Override
    public Event saveEntity(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> findByRepo(int repoId) {


        return eventRepository.findByRepoIdOrderByIdAsc(repoId);
    }

    @Override
    public Optional<Event> findByEventId(int eventId) {
        return eventRepository.findById(eventId);
    }
}
