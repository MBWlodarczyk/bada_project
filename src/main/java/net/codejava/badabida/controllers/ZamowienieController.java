package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.ZamowieniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ZamowienieController {

    @Autowired
    private final ZamowieniaRepository zamowieniaRepository;

    public ZamowienieController(ZamowieniaRepository zamowieniaRepository) {
        this.zamowieniaRepository = zamowieniaRepository;
    }

    @GetMapping("/zamowienia")
    public String getAllZamowienia(Model model){
        model.addAttribute("zamowienia",new ArrayList<Zamowienie>(zamowieniaRepository.findAll()));
        return "zamowienia.html";
    }
}
