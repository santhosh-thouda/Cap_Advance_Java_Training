package com.capgemini.librarysystem.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

@ManyToOne
@JoinColumn(name = "book_id", referencedColumnName = "id")
private Book book;

private LocalDate borrowDate;

private LocalDate returnDate;

private boolean returned;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

public LocalDate getBorrowDate() {
	return borrowDate;
}

public void setBorrowDate(LocalDate borrowDate) {
	this.borrowDate = borrowDate;
}

public LocalDate getReturnDate() {
	return returnDate;
}

public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
}

public boolean isReturned() {
	return returned;
}

public void setReturned(boolean returned) {
	this.returned = returned;
}



}