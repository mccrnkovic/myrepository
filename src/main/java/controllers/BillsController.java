package controllers;

import lombok.extern.slf4j.Slf4j;
import model.Bill;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bills")
@Slf4j
public class BillsController {

    private final UserService userService;
    private final BillService billService;

    @Autowired
    public BillsController(UserService userService, BillService billService) {
        this.userService = userService;
        this.billService = billService;
    }


    @GetMapping
    public String show(Model model){
        List<Bill> bills = billService.loadAllByUser(userService.getCurrentUser());
        model.addAttribute("bills", bills);
        return "bills";
    }
}
