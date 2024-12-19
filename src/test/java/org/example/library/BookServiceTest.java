package org.example.library;


import org.example.library.dao.BookDAO;
import org.example.library.model.Book;
import org.example.library.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookDAO bookDAO;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBooks_shouldReturnListOfBooks() {
        List<Book> books = Arrays.asList(
                new Book(1L, "Book1", "Author1", "123", true),
                new Book(2L, "Book2", "Author2", "456", true)
        );
        when(bookDAO.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
        verify(bookDAO, times(1)).findAll();
    }

    @Test
    void saveBook_shouldSaveAndReturnBook() {
        Book book = new Book(null, "Book3", "Author3", "789", true);
        when(bookDAO.save(book)).thenReturn(new Book(3L, "Book3", "Author3", "789", true));

        Book savedBook = bookService.saveBook(book);

        assertNotNull(savedBook.getId());
        assertEquals("Book3", savedBook.getTitle());
        verify(bookDAO, times(1)).save(book);
    }

    @Test
    void deleteBook_shouldCallDeleteById() {
        Long bookId = 1L;

        bookService.deleteBook(bookId);

        verify(bookDAO, times(1)).deleteById(bookId);
    }
}
