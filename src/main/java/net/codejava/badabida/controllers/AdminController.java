package net.codejava.badabida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin/home")
    public String getAdminHome() {
        return "admin/home";
    }


    @GetMapping("/admin/login")
    public String getAdminLogin() {
        return "admin/login";
    }
}