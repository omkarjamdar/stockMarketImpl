package com.example.StockMarket.controller;

import com.example.StockMarket.entity.Student;
import com.example.StockMarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody Student student)
    {
        try {
            userService.addStudent(student);
            return ResponseEntity.ok("user is created");
        }
        catch (Exception e)
        {

            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/getUser/{rollNumber}")
    public ResponseEntity<?> getUser(@PathVariable int rollNumber)
    {
      Student student =  userService.getStudent(rollNumber);
        return ResponseEntity.ok(student);
    }
}
