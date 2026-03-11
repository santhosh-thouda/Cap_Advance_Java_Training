package com.capgemini.eventsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.eventsystem.repository.EventRepository;
import com.capgemini.eventsystem.model.Event;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        event.setId(id);
        return repository.save(event);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }

    public List<Event> searchByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    public List<Event> filterByType(String type) {
        return repository.findByEventType(type);
    }
}