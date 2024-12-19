package org.example.library.service;


import org.example.library.dao.BorrowDAO;
import org.example.library.model.Borrow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    private final BorrowDAO borrowDAO;

    public BorrowServiceImpl(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    @Override
    public List<Borrow> getAllBorrows() {
        return borrowDAO.findAll();
    }

    @Override
    public Borrow saveBorrow(Borrow borrow) {
        return borrowDAO.save(borrow);
    }

    @Override
    public Borrow findBorrowById(Long id) {
        return borrowDAO.findById(id).orElseThrow(() -> new RuntimeException("Borrow not found"));
    }

    @Override
    public void markAsReturned(Long id) {
        Borrow borrow = borrowDAO.findById(id).orElseThrow(() -> new RuntimeException("Borrow not found"));
        borrow.setReturned(true);
        borrowDAO.save(borrow);
    }
}
