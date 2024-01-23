package com.example.preauthorizedemo.controller;

import com.example.preauthorizedemo.model.Employee;
import com.example.preauthorizedemo.service.BookService;
import com.example.preauthorizedemo.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final NameService nameService;
    private final BookService bookService;


    public HelloController(NameService nameService, BookService bookService){
        this.nameService = nameService;
        this.bookService = bookService;
    }
    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name){
        return bookService.getBookDetails(name);
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello, "+ nameService.getName();
    }
    @GetMapping("/secret/name/{name}")
    public List<String> getSecretNames(@PathVariable String name){
        return nameService.getSecretNames(name);
    }
}
