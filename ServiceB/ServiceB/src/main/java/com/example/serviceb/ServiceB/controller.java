package com.example.serviceb.ServiceB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controller {
    @GetMapping("/message")             //http://localhost:8081/api/message
    public String getMessage() {
        return "Message from ServiceB: Hello World!!";
    }
}
