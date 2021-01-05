package net.codejava.badabida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String getHome(){
        return "client/home";
    }

    @GetMapping("/client/home")
    public String getClientHome(){
        return "client/home";
    }

    @GetMapping("/employee/home")
    public String getEmployeeHome(){
        return "employee/home";
    }

    @GetMapping("/admin/home")
    public String getAdminHome(){
        return "admin/home";
    }



    @GetMapping("/client/login")
    public String getClientLogin(){
        return "client/login";
    }

    @GetMapping("/employee/login")
    public String getEmployeeLogin(){
        return "employee/login";
    }

    @GetMapping("/admin/login")
    public String getAdminLogin(){
        return "admin/login";
    }
}