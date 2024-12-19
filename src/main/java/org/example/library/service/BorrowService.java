package org.example.library.service;

import org.example.library.model.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> getAllBorrows();
    Borrow saveBorrow(Borrow borrow);
    Borrow findBorrowById(Long id);
    void markAsReturned(Long id);
}
