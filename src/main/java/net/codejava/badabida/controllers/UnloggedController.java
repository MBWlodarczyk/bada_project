package net.codejava.badabida.controllers;

import net.codejava.badabida.repos.CzescRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnloggedController {

    private final CzescRepository czescRepository;

    public UnloggedController(CzescRepository czescRepository) {
        this.czescRepository = czescRepository;
    }

    @GetMapping("/")
    public String getAny() {
        return "index";
    }

    @GetMapping("/start")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/store")
    public String getItemInfo(Model model) {
        model.addAttribute("czesci", czescRepository.findAll());
        return "store";
    }
}
