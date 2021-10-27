package controllers;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private BCryptPasswordEncoder BCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    private String show(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    private String register(User user){
        user.setAdmin(false);
        user.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
        log.info("Registering user: " + user);
        userService.addUser(user);
        return "redirect:/login";
    }
}
