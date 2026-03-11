package com.capgemini.librarysystem.service;

import java.util.List;
import com.capgemini.librarysystem.model.Book;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    void deleteBook(Long id);
}