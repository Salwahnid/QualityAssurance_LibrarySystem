package org.example.library.service;


import org.example.library.dao.StudentDAO;
import org.example.library.model.Student;
import org.gestionbibliotheque.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentDAO.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.deleteById(id);
    }
}
