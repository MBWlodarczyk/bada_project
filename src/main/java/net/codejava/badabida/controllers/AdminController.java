package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Czesc;
import net.codejava.badabida.repos.CzescRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    private final CzescRepository czescRepository;

    public AdminController(CzescRepository czescRepository) {
        this.czescRepository = czescRepository;
    }

    @GetMapping("/admin/home")
    public String getAdminHome(){
        return "admin/home";
    }

    @GetMapping("/admin/login")
    public String getAdminLogin(){
        return "admin/login";
    }

    @GetMapping("/admin/item/{nrCzesci}")
    public String getItemInfo(@PathVariable("nrCzesci") Long nrCzesci , Model model) {
        model.addAttribute("czesc",czescRepository.findCzescByNrCzesci(nrCzesci));
        return "admin/item";
    }

    @GetMapping("/admin/store")
    public String getStore(Model model) {
        model.addAttribute("czesci",czescRepository.findAll());
        return "admin/store";
    }

    @PostMapping("/admin/item/update/{nrCzesci}")
    public String updateItem(@PathVariable("nrCzesci") Long nrCzesci, Czesc newCzesc) {
        Czesc oldCzesc = czescRepository.findCzescByNrCzesci(nrCzesci);

        oldCzesc.setCena(newCzesc.getCena());
        oldCzesc.setCzasGwarancji(newCzesc.getCzasGwarancji());
        oldCzesc.setNazwa(newCzesc.getNazwa());
        oldCzesc.setProducent(newCzesc.getProducent());
        czescRepository.saveAndFlush(oldCzesc);

        return "admin/item";
    }
    @PostMapping("/admin/item/add")
    public String addItem(Model model, Czesc newCzesc) {
        Czesc czesc = czescRepository.saveAndFlush(newCzesc);
        System.out.println(czesc.getNrCzesci());
        return "admin/item";
    }
}
