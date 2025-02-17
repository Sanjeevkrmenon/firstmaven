package com.mycompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")  // Changed to "/" (root)
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/login")
    public String login() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}