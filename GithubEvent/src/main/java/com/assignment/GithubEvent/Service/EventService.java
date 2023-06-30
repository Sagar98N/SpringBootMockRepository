package com.assignment.GithubEvent.Service;

import com.assignment.GithubEvent.Entity.Event;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface EventService {

    public Event saveEntity(Event event);

    public List<Event> getAllEvents();

    public List<Event> findByRepo(int repoId);

    public Optional<Event> findByEventId(int eventId);
}
