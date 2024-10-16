package com.example.StockMarket.services;

import com.example.StockMarket.entity.Student;
import com.example.StockMarket.entity.Subject;
import com.example.StockMarket.repository.StudentRepository;
import com.example.StockMarket.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;
    public void addStudent(Student student)
    {
            subjectRepository.saveAll(student.getSubject());
            studentRepository.save(student);
    }

    public Student getStudent(int rollNumber)
    {
        Student student = studentRepository.findByRollNumber(rollNumber);
        return student;
    }
}
