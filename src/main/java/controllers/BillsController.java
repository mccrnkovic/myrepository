package controllers;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bills")
@Slf4j
public class BillsController {

    private final UserService userService;

    @Autowired
    public BillsController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String show(Model model){
        User user = userService.getCurrentUser();

        return "bills";
    }
}
