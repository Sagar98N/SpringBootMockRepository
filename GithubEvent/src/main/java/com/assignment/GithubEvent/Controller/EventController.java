package com.assignment.GithubEvent.Controller;

import com.assignment.GithubEvent.Entity.Event;
import com.assignment.GithubEvent.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/events")
    public ResponseEntity<Event> save(@RequestBody Event event){
        Event event1 = eventService.saveEntity(event);
        return  new ResponseEntity<>(event1, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAll(){
        List<Event> list = eventService.getAllEvents();
        return  new ResponseEntity<>(list, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/repos/{repoId}/events")
    public ResponseEntity<List<Event>> getAllByRepo(@PathVariable int repoId){
        List<Event> list = eventService.findByRepo(repoId);
        return  new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<Optional<Event>> getAllByEvent(@PathVariable int eventId){
        Optional<Event> event = eventService.findByEventId(eventId);
        if(event.isPresent()){
            return  new ResponseEntity<>(event, HttpStatusCode.valueOf(200));
        }

        return new ResponseEntity<>(HttpStatusCode.valueOf(404));

    }
}
