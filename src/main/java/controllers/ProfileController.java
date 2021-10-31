package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String show(Model model){
        Object userDetailsObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "None";
        if(userDetailsObject instanceof UserDetails){
            username=((UserDetails) userDetailsObject).getUsername();
        }

        User user= (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);
        return "profile";
    }
}
