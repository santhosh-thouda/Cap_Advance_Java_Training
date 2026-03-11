package com.capgemini.eventsystem.service;

import java.util.List;
import com.capgemini.eventsystem.model.Event;

public interface EventService {

    List<Event> getAllEvents();

    Event getEventById(Long id);

    Event createEvent(Event event);

    Event updateEvent(Long id, Event event);

    void deleteEvent(Long id);

    List<Event> searchByTitle(String title);

    List<Event> filterByType(String type);
}