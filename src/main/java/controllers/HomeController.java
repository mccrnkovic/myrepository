package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    private String show(){
        return "home";
    }

    @PostMapping
    private String login(){
        return "login";
    }
}
