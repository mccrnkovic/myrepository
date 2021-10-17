package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    private String show(){
        return "home";
    }

    @RequestMapping("/test")
    private String test(){
        return "test";
    }
}
