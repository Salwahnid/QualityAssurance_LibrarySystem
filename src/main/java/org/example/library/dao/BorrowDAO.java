package org.example.library.dao;

import org.example.library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowDAO extends JpaRepository<Borrow, Long> {
}
