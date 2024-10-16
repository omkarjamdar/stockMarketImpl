package com.example.StockMarket.controller;

import com.example.StockMarket.entity.Student;
import com.example.StockMarket.entity.User;
import com.example.StockMarket.services.StudentService;
import com.example.StockMarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("user is created");
        }
        catch (Exception e)
        {

            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/getUser/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username)
    {

            User user = userService.getUser(username);
           if(user != null)
           {
            return ResponseEntity.ok(user);
        }
        else
        {
            throw new NullPointerException(username);
        }
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleUserNotFound(NullPointerException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "User Not Found");
        response.put("message", ex.getMessage());
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
