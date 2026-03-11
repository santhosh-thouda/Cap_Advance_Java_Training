package com.capgemini.eventsystem.model;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class Event {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String title;

private String description;

private String eventType;

private String location;

private LocalDate eventDate;

private LocalTime startTime;

private LocalTime endTime;

private String organizerName;

private String contactPhone;

private String status;

private LocalDateTime createdAt;

private LocalDateTime updatedAt;

public Event(){}

public Long getId(){ return id; }
public void setId(Long id){ this.id=id; }

public String getTitle(){ return title; }
public void setTitle(String title){ this.title=title; }

public String getDescription(){ return description; }
public void setDescription(String description){ this.description=description; }

public String getEventType(){ return eventType; }
public void setEventType(String eventType){ this.eventType=eventType; }

public String getLocation(){ return location; }
public void setLocation(String location){ this.location=location; }

public LocalDate getEventDate(){ return eventDate; }
public void setEventDate(LocalDate eventDate){ this.eventDate=eventDate; }

public LocalTime getStartTime(){ return startTime; }
public void setStartTime(LocalTime startTime){ this.startTime=startTime; }

public LocalTime getEndTime(){ return endTime; }
public void setEndTime(LocalTime endTime){ this.endTime=endTime; }

public String getOrganizerName(){ return organizerName; }
public void setOrganizerName(String organizerName){ this.organizerName=organizerName; }

public String getContactPhone(){ return contactPhone; }
public void setContactPhone(String contactPhone){ this.contactPhone=contactPhone; }

public String getStatus(){ return status; }
public void setStatus(String status){ this.status=status; }

public LocalDateTime getCreatedAt(){ return createdAt; }
public void setCreatedAt(LocalDateTime createdAt){ this.createdAt=createdAt; }

public LocalDateTime getUpdatedAt(){ return updatedAt; }
public void setUpdatedAt(LocalDateTime updatedAt){ this.updatedAt=updatedAt; }

}