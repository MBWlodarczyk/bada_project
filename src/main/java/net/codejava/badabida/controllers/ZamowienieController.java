package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.KlientRepository;
import net.codejava.badabida.repos.ZamowieniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ZamowienieController {

    @Autowired
    private final ZamowieniaRepository zamowieniaRepository;
    private final KlientRepository klientRepository;

    public ZamowienieController(ZamowieniaRepository zamowieniaRepository, KlientRepository klientRepository) {
        this.zamowieniaRepository = zamowieniaRepository;
        this.klientRepository = klientRepository;
    }

    @GetMapping("client/zamowienia")
    @Transactional
    public String getAllZamowienia(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            String username2 = ((UserDetails) principal).getPassword();
            String username3 = ((UserDetails) principal).getAuthorities().toString();
            System.out.println(username);
            System.out.println(username2);
            System.out.println(username3);
            model.addAttribute("zamowienia", klientRepository.findByUsername(username).get().getZamowienia());
        } else {
            String username = principal.toString();
            System.out.println(username);

        }

        //model.addAttribute("zamowienia", new ArrayList<Zamowienie>(zamowieniaRepository.findAll()));
        return "client/zamowienia.html";
    }

    @GetMapping("/client/dane")
    @Transactional
    public String getClientInfo(Model model) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("klient", klientRepository.findByUsername(principal.getUsername()).get());
        return "client/dane";
    }
}
