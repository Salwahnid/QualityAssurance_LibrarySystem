package org.example.library.controller;

import org.example.library.model.Borrow;
import org.example.library.service.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        return ResponseEntity.ok(borrowService.getAllBorrows());
    }

    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@RequestBody Borrow borrow) {
        return ResponseEntity.ok(borrowService.saveBorrow(borrow));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowService.findBorrowById(id));
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Void> markAsReturned(@PathVariable Long id) {
        borrowService.markAsReturned(id);
        return ResponseEntity.noContent().build();
    }
}
