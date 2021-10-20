package controllers;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping
    private String show(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    private String register(User user) {
        log.info("Registering user: " + user);
        return "home";
    }
}
