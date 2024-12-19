package org.example.library;

import org.example.library.dao.StudentDAO;
import org.example.library.model.Student;
import org.example.library.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveStudent_shouldSaveAndReturnStudent() {
        Student student = new Student(null, "John", "Doe", "john.doe@example.com");
        when(studentDAO.save(student)).thenReturn(new Student(1L, "John", "Doe", "john.doe@example.com"));

        Student savedStudent = studentService.saveStudent(student);

        assertNotNull(savedStudent.getId());
        assertEquals("John", savedStudent.getFirstName());
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void findStudentById_shouldReturnStudentIfFound() {
        Long studentId = 1L;
        Student student = new Student(1L, "John", "Doe", "john.doe@example.com");
        when(studentDAO.findById(studentId)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.findStudentById(studentId);

        assertNotNull(foundStudent);
        assertEquals("John", foundStudent.getFirstName());
        verify(studentDAO, times(1)).findById(studentId);
    }

    @Test
    void findStudentById_shouldThrowExceptionIfNotFound() {
        Long studentId = 1L;
        when(studentDAO.findById(studentId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            studentService.findStudentById(studentId);
        });

        assertEquals("Student not found", exception.getMessage());
        verify(studentDAO, times(1)).findById(studentId);
    }
}
