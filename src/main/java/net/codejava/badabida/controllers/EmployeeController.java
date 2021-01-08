package net.codejava.badabida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {


    @GetMapping("/employee/home")
    public String getEmployeeHome() {
        return "employee/home";
    }


    @GetMapping("/employee/login")
    public String getEmployeeLogin() {
        return "employee/login";
    }

}
