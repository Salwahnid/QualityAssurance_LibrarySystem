package org.example.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Student student;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private boolean returned = false;
}
