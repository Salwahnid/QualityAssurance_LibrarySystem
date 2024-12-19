package org.example.library;

import org.example.library.dao.BorrowDAO;
import org.example.library.model.Book;
import org.example.library.model.Borrow;
import org.example.library.model.Student;
import org.example.library.service.BorrowServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BorrowServiceTest {

    @Mock
    private BorrowDAO borrowDAO;

    @InjectMocks
    private BorrowServiceImpl borrowService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveBorrow_shouldSaveAndReturnBorrow() {
        Borrow borrow = new Borrow(null, new Book(), new Student(), LocalDate.now(), null, false);
        when(borrowDAO.save(borrow)).thenReturn(new Borrow(1L, new Book(), new Student(), LocalDate.now(), null, false));

        Borrow savedBorrow = borrowService.saveBorrow(borrow);

        assertNotNull(savedBorrow.getId());
        verify(borrowDAO, times(1)).save(borrow);
    }

    @Test
    void markAsReturned_shouldUpdateBorrowToReturned() {
        Long borrowId = 1L;
        Borrow borrow = new Borrow(1L, new Book(), new Student(), LocalDate.now(), null, false);
        when(borrowDAO.findById(borrowId)).thenReturn(Optional.of(borrow));

        borrowService.markAsReturned(borrowId);

        assertTrue(borrow.isReturned());
        verify(borrowDAO, times(1)).save(borrow);
    }
}
