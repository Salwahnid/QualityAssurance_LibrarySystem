package org.example.library.service;

import org.example.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    void deleteBook(Long id);

}
