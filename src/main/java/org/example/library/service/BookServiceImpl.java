package org.example.library.service;

import org.example.library.dao.BookDAO;
import org.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookDAO.deleteById(id);
    }
}
