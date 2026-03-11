package com.capgemini.librarysystem.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarysystem.model.Book;
import com.capgemini.librarysystem.model.BorrowRecord;
import com.capgemini.librarysystem.model.User;
import com.capgemini.librarysystem.repository.BookRepository;
import com.capgemini.librarysystem.repository.BorrowRecordRepository;
import com.capgemini.librarysystem.repository.UserRepository;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository recordRepository;

    @PostMapping
    public BorrowRecord borrowBook(@RequestParam Long userId,
                                   @RequestParam Long bookId) {

        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        if(!book.isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        book.setAvailable(false);
        bookRepository.save(book);

        return recordRepository.save(record);
    }
}