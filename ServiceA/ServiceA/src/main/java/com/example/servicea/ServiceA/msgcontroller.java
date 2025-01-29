package com.example.servicea.ServiceA;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class msgcontroller {
    private final ServiceMessage serviceMessage;

    public msgcontroller(ServiceMessage serviceMessage) {

        this.serviceMessage = serviceMessage;
    }

    @GetMapping("/greetings")
    public String showmsg(Model model) {
        String message = serviceMessage.getMessage();
        model.addAttribute("message", message);
        return "index";
    }
}
