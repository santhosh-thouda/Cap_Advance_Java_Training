package com.capgemini.eventsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.eventsystem.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventType(String eventType);

    List<Event> findByTitleContaining(String title);

}