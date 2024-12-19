package org.gestionbibliotheque.service;


import org.example.library.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student findStudentById(Long id);
    void deleteStudent(Long id);
}
