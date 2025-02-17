package com.mycompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller; // ADD THIS LINE
import org.springframework.ui.Model;

@SpringBootApplication
@Controller
public class App {

    @GetMapping("/")  // Changed to "/" (root)
    public String sayHello() {
        return "Hello, World!";
    }


    @GetMapping("/login")
    public String login(Model model) {
        return "login"; // Returns the name of the template (login.html)
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}