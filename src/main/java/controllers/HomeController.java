package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    private String show(){
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails){
            return "loginHome";
        }
        return "home";
    }

    /*@GetMapping("/home")
    private String home(){
        return "loginHome";
    }*/

    @GetMapping("/login")
    private String login(){
        return "login";
    }
}
