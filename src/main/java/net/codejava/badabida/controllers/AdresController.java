package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.repos.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AdresController {

    @Autowired
    private final AdresRepository adresRepository;

    public AdresController(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    @GetMapping("/adresy")
    public String getAllAdresy(Model model) {
        model.addAttribute("adresy", new ArrayList<Adres>(adresRepository.findAll()));
        return "adresy";
    }
}
