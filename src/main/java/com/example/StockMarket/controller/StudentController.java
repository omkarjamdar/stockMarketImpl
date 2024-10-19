package com.example.StockMarket.controller;

import com.example.StockMarket.entity.Student;
import com.example.StockMarket.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student)
    {
        try {
            studentService.addStudent(student);
            return ResponseEntity.ok("user is created");
        }
        catch (Exception e)
        {

            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/getStudent/{rollNumber}")
    public ResponseEntity<?> getStudent(@PathVariable int rollNumber)
    {
        Student student =  studentService.getStudent(rollNumber);
        return ResponseEntity.ok(student);
    }
}
