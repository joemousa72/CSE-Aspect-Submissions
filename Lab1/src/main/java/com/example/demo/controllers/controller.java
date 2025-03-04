package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class controller {  // Class name should start with a capital letter
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @DeleteMapping("/hello")
    public String sayDelete() {
        return "Delete";
    }

    @PostMapping("/hello")
    public String sayPost() {
        return "Post";
    }

    @PutMapping("/hello")
    public String sayPut() {
        return "Put";
    }
}
