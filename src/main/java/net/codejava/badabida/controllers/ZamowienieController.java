package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.ZamowieniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("client/zamowienia")
    public String getAllZamowienia(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username1 = ((UserDetails)principal).getUsername();
            String username2 = ((UserDetails)principal).getPassword();
            String username3 = ((UserDetails)principal).getAuthorities().toString();
            System.out.println(username1);
            System.out.println(username2);
            System.out.println(username3);
        } else {
            String username = principal.toString();
            System.out.println(username);

        }




        model.addAttribute("zamowienia", new ArrayList<Zamowienie>(zamowieniaRepository.findAll()));
        return "client/zamowienia.html";
    }
}
